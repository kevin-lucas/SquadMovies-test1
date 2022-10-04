package com.example.squadmovies.data.mappers

import com.example.squadmovies.domain.entities.Movie
import com.example.squadmovies.projeto.model.MovieResponse

object CoinsMappers {
    fun fromRemoteToDomain(movieList: List<MovieResponse>): List<Movie> {
        return movieList.map { fromRemoteToDomain(it) }
    }

    fun fromRemoteToDomain(movie: MovieResponse): Movie =
        Movie(
            movie.title,
            movie.year,
            movie.poster,
            movie.plot,
            movie.language,
            movie.imdbID,
            movie.response
        )
}
