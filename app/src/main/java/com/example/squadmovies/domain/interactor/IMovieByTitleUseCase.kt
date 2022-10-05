package com.example.squadmovies.domain.interactor

import com.example.squadmovies.domain.entities.Movie

interface IMovieByTitleUseCase {
    suspend fun getMovieByTitleRepository(title: String): List<Movie>?
}
