package com.example.squadmovies.domain.entities

import com.example.squadmovies.projeto.model.SearchMovieResponse


object MoviesMappers {
    fun remoteToDomain(MovieList: List<SearchMovieResponse>): List<Movie> {
        return MovieList.map { fromRemoteToDomain(it) }
    }

    fun fromRemoteToDomain(movie: Movie): Movie =
        Movie(
            movie.year,
            movie.title,
            movie.language,
            movie.year,
            movie.imdbID,
            movie.plot,
            movie.poster

        )
}
