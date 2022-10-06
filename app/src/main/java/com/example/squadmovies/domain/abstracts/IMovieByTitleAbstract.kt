package com.example.squadmovies.domain.abstracts

import com.example.squadmovies.domain.entities.MovieDomainEntities

interface IMovieByTitleAbstract {

    suspend fun getMovieByTitleRepository(title: String): List<MovieDomainEntities>?
}
