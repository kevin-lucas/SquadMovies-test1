package com.example.squadmovies.respository

import com.example.squadmovies.projeto.model.MovieResponse
import com.example.squadmovies.projeto.model.SearchMovieResponse
import com.example.squadmovies.projeto.network.IRetrofitService
import retrofit2.Call

class MovieRepository(private val iRetrofitService: IRetrofitService) {

    suspend fun getList(): Call<SearchMovieResponse> {
        return iRetrofitService.getListMovies()
    }

    suspend fun getTitle(title: String): Call<SearchMovieResponse> {
        return iRetrofitService.searchMovieByTitle()
    }

    suspend fun getListDetails(title: String): Call<MovieResponse> {
        return iRetrofitService.getListDetailsMovies()
    }
}