package com.example.squadmovies.domain.interactor

import com.example.squadmovies.domain.entities.MovieDomainEntities

interface IAllMovieUseCase {
    suspend fun getAllMoviesRepository(): List<MovieDomainEntities>?
}