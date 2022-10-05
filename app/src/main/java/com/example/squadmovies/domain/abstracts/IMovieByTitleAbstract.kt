package com.example.squadmovies.domain.abstracts

import com.example.squadmovies.domain.entities.Movie

interface IMovieByTitleAbstract {
    suspend fun getMovieByTitleRepository(title: String): List<Movie>?
}
