package com.myprojects.watchfilm

import com.myprojects.watchfilm.POJO.Film
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.GET
import retrofit2.http.QueryMap

class NetworkService private constructor() {
    private val mRetrofit: Retrofit

    interface APIService {
        @GET("/svc/movies/v2/reviews/search.json")
        fun getFilms(@QueryMap map: Map<String, String>): Call<Film>



    }
    val aPI: APIService
        get() = mRetrofit.create(APIService::class.java)

    companion object {
        private var mInstance: NetworkService? = null
        private const val BASE_URL = "https://api.nytimes.com"

        //Singleton for class
        val instance: NetworkService?
            get() {
                if (mInstance == null) {
                    mInstance = NetworkService()
                }
                return mInstance
            }
    }

    // declare and initialize Retrofit
    init {
        mRetrofit = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(MoshiConverterFactory.create())
            .build()
    }
}