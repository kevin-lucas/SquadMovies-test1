package com.example.squadmovies.domain.usecase

import com.example.squadmovies.data.respository.MovieRepository
import com.example.squadmovies.projeto.model.Movie


class MovieUseCase(private val movieRepository: MovieRepository) {

    suspend fun getAllMovie(): List<Movie>? {
        return getAllMovies()
    }

    private suspend fun getAllMovies(): List<Movie>? {
        val result =
