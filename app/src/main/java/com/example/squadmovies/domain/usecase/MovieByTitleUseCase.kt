package com.example.squadmovies.domain.usecase

import com.example.squadmovies.domain.abstracts.IMovieByTitleAbstract
import com.example.squadmovies.domain.entities.Movie
import com.example.squadmovies.domain.interactor.IMovieByTitleUseCase

class MovieByTitleUseCase(private val iMovieByTItleAbstract: IMovieByTitleAbstract) : IMovieByTitleUseCase {

    override suspend fun getMovieByTitleRepository(title: String): List<Movie>? {
        val resultMovies = iMovieByTItleAbstract.getMovieByTitleRepository(title)
        resultMovies?.let {
            return resultMovies
        } ?: run {
            return null
        }
    }
}
