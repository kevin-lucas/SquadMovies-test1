package com.example.squadmovies.domain.interactor

import com.example.squadmovies.data.dao.MovieEntity

interface IMovieGetIdUseCase {

    suspend fun getIdMovie(imdbID: String): MovieEntity?
}
