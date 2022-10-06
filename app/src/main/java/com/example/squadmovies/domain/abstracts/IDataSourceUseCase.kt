package com.example.squadmovies.domain.abstracts

import com.example.squadmovies.data.dao.MovieEntity

interface IDataSourceUseCase {

    suspend fun insertMovieI(movie: MovieEntity): String

    suspend fun deleteMovie(title: String)

    suspend fun getAllMovies(): List<MovieEntity>

    suspend fun getByImdbId(imdbID: String): MovieEntity?
}

