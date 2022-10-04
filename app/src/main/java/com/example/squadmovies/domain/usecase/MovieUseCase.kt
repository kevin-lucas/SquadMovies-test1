package com.example.squadmovies.domain.usecase

import com.example.squadmovies.data.respository.MovieRepository
import com.example.squadmovies.projeto.model.MovieResponse
import retrofit2.await

class MovieUseCase(private val movieRepository: MovieRepository) {

    suspend fun getResultListMovies(): List<MovieResponse>? {
        return movieRepository.getListMovies().await().movies
    }
}
