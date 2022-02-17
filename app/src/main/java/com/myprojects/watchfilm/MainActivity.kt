package com.myprojects.watchfilm

import android.os.Bundle

import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.myprojects.watchfilm.POJO.Film
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {
    private val apiKey:String = "cY1jUkIeVJzSIUGCr75BVMqfAJvgOsBM"
    lateinit var recyclerView: RecyclerView
    lateinit var adapter: FilmRecyclerViewAdapter
    lateinit var film: Film
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        recyclerView = findViewById(R.id.recyclerView)
        doMySearch()
    }
    private fun doMySearch() {
        val data: MutableMap<String, String> = HashMap()
        data["query"] = "all"
        data["api-key"] = apiKey

        NetworkService.instance?.aPI?.getFilms(data)?.enqueue(object : Callback<Film> {
            override fun onResponse(call: Call<Film>, response: Response<Film>) {
                film = response.body()!!
                recyclerView.layoutManager = LinearLayoutManager(this@MainActivity)
                adapter = FilmRecyclerViewAdapter(this@MainActivity, film)
                recyclerView.adapter = adapter
            }

            override fun onFailure(call: Call<Film>, t: Throwable) {
                Toast.makeText(
                    this@MainActivity, "Error occurred while getting request",
                    Toast.LENGTH_SHORT
                ).show()
                Log.e("Tag", "Вот эта коварная ошибка " + t.toString())
            }
        })
    }
}