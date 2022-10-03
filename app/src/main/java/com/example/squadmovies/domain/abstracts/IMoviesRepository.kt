package com.example.squadmovies.domain.abstracts

import com.example.squadmovies.projeto.model.MovieResponse

interface IMoviesRepository {
    suspend fun getAllMoviesRepository(): List<MovieResponse>?
}
