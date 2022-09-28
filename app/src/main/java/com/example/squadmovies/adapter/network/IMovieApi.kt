package com.example.squadmovies.adapter.network

import com.example.squadmovies.adapter.model.MovieDetailsResponse
import com.example.squadmovies.adapter.model.MovieResponse
import com.example.squadmovies.adapter.model.SearchMovieResponse
import com.example.squadmovies.adapter.utils.Constants.Companion.BASE_URL
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

    @GET("?apikey=a487beb6")
    fun getListDetailsMovies(
        @Query("t") title: String = "aaa"
    ): Call<MovieDetailsResponse>

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
