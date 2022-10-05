package com.example.squadmovies.domain.interactor

import com.example.squadmovies.domain.entities.Movie

interface IMovieGetIdUseCase {

    suspend fun getIdMovie(imdbID: String): Movie?
}
