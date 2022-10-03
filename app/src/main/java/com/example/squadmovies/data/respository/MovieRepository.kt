package com.example.squadmovies.data.respository

import com.example.squadmovies.domain.abstracts.IMoviesRepository
import com.example.squadmovies.domain.entities.Movie
import com.example.squadmovies.domain.entities.MoviesMappers
import com.example.squadmovies.projeto.network.IRetrofitService

class MovieRepository(private val retrofit: IRetrofitService) : IMoviesRepository {

    override suspend fun getAllMoviesRepository(): List<Movie>? {
        val result = retrofit.getListMovies()
        result.body()?.let {
            return MoviesMappers.remoteToDomain(it)
        } ?: run {
            return null
        }
    }
}
