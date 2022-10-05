package com.example.squadmovies.domain.abstracts

import com.example.squadmovies.domain.entities.Movie

interface IMovieAllAbstract {

    suspend fun getAllMoviesRepository(): List<Movie>?
}
