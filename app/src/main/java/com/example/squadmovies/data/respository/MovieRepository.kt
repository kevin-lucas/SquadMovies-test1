package com.example.squadmovies.data.respository

import com.example.squadmovies.projeto.network.IRetrofitService
import com.example.squadmovies.projeto.utils.Constants

class MovieRepository(private val retrofit: IRetrofitService) {
    fun getListMovies() = retrofit.searchMovies(Constants.MOVIE_TITLE)
}
