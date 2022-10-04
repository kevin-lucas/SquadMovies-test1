package com.example.squadmovies.projeto.network

import com.example.squadmovies.projeto.model.MovieResponse
import com.example.squadmovies.projeto.model.SearchBaseMovieResponse
import com.example.squadmovies.projeto.utils.Constants.Companion.BASE_URL
import retrofit2.Call
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query

interface IRetrofitService {
    @GET("?apikey=a487beb6")
    suspend fun getAllMovies(
        @Query("s") movies: String = "aaa"
    ): Response<SearchBaseMovieResponse>

    @GET("?apikey=a487beb6")
    suspend fun getMovieByTitle(
        @Query("s") title: String
    ): Response<SearchBaseMovieResponse>

    @GET("?apikey=a487beb6")
    suspend fun getMovie(
        @Query("i") imdbID: String
    ): Response<MovieResponse>

    companion object {

        private val retrofit: IRetrofitService by lazy {
            val retrofit = Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
            retrofit.create(IRetrofitService::class.java)
        }
        fun getBaseUrl(): IRetrofitService {
            return retrofit
        }
    }
}
