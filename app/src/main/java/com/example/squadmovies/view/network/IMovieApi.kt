package com.example.squadmovies.view.network

import com.example.squadmovies.view.model.MovieResponse
import com.example.squadmovies.view.model.SearchMovieResponse
import com.example.squadmovies.view.utils.Constants.Companion.BASE_URL
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query

interface RetrofitService {
    @GET("?apikey=a487beb6")
    fun getListMovies(
        @Query("t") title: String = "aaa"
    ): Call<MovieResponse>

    @GET("?apikey=a487beb6")
    fun searchMovieByName(
        @Query("s") title: String
    ): Call<SearchMovieResponse>

    companion object {

        private val retrofit: RetrofitService by lazy {
            val retrofit = Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
            retrofit.create(RetrofitService::class.java)
        }
        fun getBaseUrl(): RetrofitService {
            return retrofit
        }
    }
}
