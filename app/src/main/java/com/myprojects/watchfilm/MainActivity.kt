package com.myprojects.watchfilm

import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.myprojects.watchfilm.POJO.Film
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class MainActivity : AppCompatActivity() {
    private val apiKey: String = BuildConfig.API_KEY
    lateinit var recyclerView: RecyclerView
    lateinit var adapter: FilmRecyclerViewAdapter
    lateinit var film: Film
    lateinit var listFilm: ArrayList<Film>
    private var offset = 0
    var isAdapterSetOnce = false
    var isLoading = false
    var count = 0
        set(value) {
            if (value < listFilm.size)
                field = value
            else {
                field = 0
            }
        }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        recyclerView = findViewById(R.id.recyclerView)
        recyclerView.addItemDecoration(DividerItemDecoration(this, DividerItemDecoration.VERTICAL))
        listFilm = ArrayList()
        recyclerView.addOnScrollListener(object : RecyclerView.OnScrollListener() {
            override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
                val layoutManager = LinearLayoutManager::class.java.cast(recyclerView.layoutManager)
                super.onScrolled(recyclerView, dx, dy)
                val totalItem: Int = layoutManager.itemCount
                val lastVisibleItem: Int = layoutManager.findLastVisibleItemPosition()
                if (!isLoading && lastVisibleItem == totalItem - 1) {
                    isLoading = true
                   // I did not figure out how to connect data in one adapter.
                    // Therefore, I create a new adapter every time
                    adapter = FilmRecyclerViewAdapter(this@MainActivity, listFilm.get(count++))
                    recyclerView.adapter = adapter
                    adapter.notifyDataSetChanged()
                    isLoading = false
                }
            }
        })
        loadMovies()
    }

    private fun loadMovies() {
        val data: MutableMap<String, String> = HashMap()
        data["query"] = "all"
        data["offset"] = offset.toString()
        data["api-key"] = apiKey

        NetworkService.instance?.aPI?.getFilms(data)?.enqueue(object : Callback<Film?> {
            override fun onResponse(call: Call<Film?>, response: Response<Film?>) {
                if (response.body() != null) {
                    film = response.body()!!
                    listFilm.add(film)
                    offset += 20
                    loadMovies()
                }
                setAdapter()
            }


            override fun onFailure(call: Call<Film?>, t: Throwable) {
                Toast.makeText(
                    this@MainActivity, "Error occurred while getting request",
                    Toast.LENGTH_SHORT
                ).show()
                Log.e("Tag", "Вот эта коварная ошибка " + t.toString())
            }
        })
    }

    private fun setAdapter() {
        if (isAdapterSetOnce == false) {
            recyclerView.layoutManager = LinearLayoutManager(this@MainActivity)
            adapter = FilmRecyclerViewAdapter(this@MainActivity, film)
            recyclerView.adapter = adapter
            isAdapterSetOnce = true
        }
    }
}