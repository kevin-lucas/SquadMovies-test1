package com.example.squadmovies.data.respository

import com.example.squadmovies.domain.abstracts.IMovieAllAbstract
import com.example.squadmovies.domain.entities.Movie
import com.example.squadmovies.projeto.network.IRetrofitService
import com.example.squadmovies.test.mappers.CoinsMappers

class AllMoviesRepository(private val retrofit: IRetrofitService) : IMovieAllAbstract {

    override suspend fun getAllMoviesRepository(): List<Movie>? {
        val response = retrofit.getAllMovies()
        response.body()?.let { body ->
            body.movies?.let { movies ->
                return CoinsMappers.fromRemoteToDomain(movies)
            }
        } ?: run {
            return null
        }
    }
}
