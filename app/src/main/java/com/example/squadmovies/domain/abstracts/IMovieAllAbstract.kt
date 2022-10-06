package com.example.squadmovies.domain.abstracts

import com.example.squadmovies.domain.entities.MovieDomainEntities

interface IMovieAllAbstract {

    suspend fun getAllMoviesRepository(): List<MovieDomainEntities>?
}
