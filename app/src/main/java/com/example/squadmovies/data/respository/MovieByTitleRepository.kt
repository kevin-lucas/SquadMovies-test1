package com.example.squadmovies.data.respository

import com.example.squadmovies.domain.abstracts.IMovieByTitleAbstract
import com.example.squadmovies.domain.entities.Movie
import com.example.squadmovies.projeto.network.IRetrofitService
import com.example.squadmovies.test.mappers.CoinsMappers

class MovieByTitleRepository(private val retrofit: IRetrofitService) : IMovieByTitleAbstract {

    override suspend fun getMovieByTitleRepository(title: String): List<Movie>? {
        val response = retrofit.getMovieByTitle(title)
        response.body()?.let { body ->
            body.movies?.let { movies ->
                return CoinsMappers.fromRemoteToDomain(movies)
            }
        } ?: run {
            return null
        }
    }
}
