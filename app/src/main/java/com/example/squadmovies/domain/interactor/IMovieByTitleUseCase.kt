package com.example.squadmovies.domain.interactor

import com.example.squadmovies.domain.entities.MovieDomainEntities

interface IMovieByTitleUseCase {
    suspend fun getMovieByTitleRepository(title: String): List<MovieDomainEntities>?
}
