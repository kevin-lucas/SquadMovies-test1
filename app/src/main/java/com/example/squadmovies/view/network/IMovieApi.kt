package com.example.squadmovies.view.network

import com.example.squadmovies.view.model.SearchMovieResponse
import com.example.squadmovies.view.utils.Constants.Companion.BASE_URL
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query

interface IMovieApi {
    @GET("?apikey=a487beb6")
    suspend fun getListMovies(
        @Query("t") title: String = "aaa"
    ): Call<SearchMovieResponse>

    @GET("?apikey=a487beb6")
    fun searchMovieByName(
        @Query("s") title: String
    ): Call<SearchMovieResponse>

    companion object {

        private val retrofit: IMovieApi by lazy {
            val retrofit = Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
            retrofit.create(IMovieApi::class.java)
        }
        fun getBaseUrl(): IMovieApi {
            return retrofit
        }
    }
}

