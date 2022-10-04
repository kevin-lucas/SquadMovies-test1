package com.example.squadmovies.domain.interactor

import com.example.squadmovies.domain.entities.Movie

interface IMoviesUseCase {
    suspend fun getAllMoviesRepository(): List<Movie>?
}

