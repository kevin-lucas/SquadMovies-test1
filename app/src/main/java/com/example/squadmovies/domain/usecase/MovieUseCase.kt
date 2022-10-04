package com.example.squadmovies.domain.usecase

import com.example.squadmovies.domain.abstracts.IMovieAllAbstract
import com.example.squadmovies.domain.entities.Movie
import com.example.squadmovies.domain.interactor.IMoviesUseCase

class MovieUseCase(private val iMovieAllAbstract: IMovieAllAbstract) : IMoviesUseCase {

    override suspend fun getAllMoviesRepository(): List<Movie>? {
        val resultMovies = iMovieAllAbstract.getAllMoviesRepository()

        resultMovies?.let {
            return resultMovies
        } ?: run {
            return null
        }
    }
}
