package com.example.squadmovies.domain.usecase

import com.example.squadmovies.domain.abstracts.IMovieAllAbstract
import com.example.squadmovies.domain.entities.MovieDomainEntities
import com.example.squadmovies.domain.interactor.IAllMovieUseCase

class IAllMovieUseCase(private val iMovieAllAbstract: IMovieAllAbstract) :
    IAllMovieUseCase {

    override suspend fun getAllMoviesRepository(): List<MovieDomainEntities>? {
        val resultMovies = iMovieAllAbstract.getAllMoviesRepository()

        resultMovies?.let {
            return resultMovies
        } ?: run {
            return null
        }
    }
}
