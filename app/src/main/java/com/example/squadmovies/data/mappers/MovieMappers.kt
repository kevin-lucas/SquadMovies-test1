package com.example.squadmovies.test.mappers

import com.example.squadmovies.domain.entities.MovieDomainEntities
import com.example.squadmovies.data.model.MovieResponse

object CoinsMappers {
    fun fromRemoteToDomain(movieList: List<MovieResponse>): List<MovieDomainEntities> {
        return movieList.map { fromRemoteToDomain(it) } //fazemos a conversao do objeto movieList/Movie
    }

    fun fromRemoteToDomain(movie: MovieResponse): MovieDomainEntities =
        MovieDomainEntities(
            movie.title,
            movie.year,
            movie.poster,
            movie.plot,
            movie.language,
            movie.imdbID,
            movie.response
        )
}
