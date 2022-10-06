package com.example.squadmovies.data.respository

import com.example.squadmovies.data.dao.IMovieDAO
import com.example.squadmovies.data.dao.MovieEntity
import com.example.squadmovies.domain.abstracts.IDataSourceUseCase

class DataSourceRespository(private val iMovieDAO: IMovieDAO) : IDataSourceUseCase {
    override suspend fun insertMovieI(movie: MovieEntity): String {
        return iMovieDAO.insert(movie = movie)
    }

    override suspend fun deleteMovie(title: String) {
        return iMovieDAO.delete(title)
    }

    override suspend fun getAllMovies(): List<MovieEntity> {
        return iMovieDAO.allMovie()
    }

    override suspend fun getByImdbId(imdbID: String): MovieEntity? {
        return iMovieDAO.getByImdbId(imdbID)
    }
}
