package com.example.squadmovies.data.respository

import com.example.squadmovies.domain.abstracts.IMovieGetIdMovieAbstract
import com.example.squadmovies.domain.entities.MovieDomainEntities
import com.example.squadmovies.projeto.network.IRetrofitService
import com.example.squadmovies.test.mappers.CoinsMappers

class GetIdMovieRepository(private val retrofit: IRetrofitService) : IMovieGetIdMovieAbstract {

    override suspend fun getIdMovieRepository(imdbID: String): MovieDomainEntities? {
        val response = retrofit.getMovie(imdbID)
        response.body()?.let { movie ->
            return CoinsMappers.fromRemoteToDomain(movie)
        } ?: run {
            return null
        }
    }
}
