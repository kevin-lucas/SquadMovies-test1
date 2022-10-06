package com.example.squadmovies.domain.usecase

import com.example.squadmovies.data.dao.MovieEntity
import com.example.squadmovies.domain.abstracts.IMovieGetIdMovieAbstract
import com.example.squadmovies.domain.interactor.IMovieGetIdUseCase

class IMovieGetIdUsecase(private val iDMovieAbstract: IMovieGetIdMovieAbstract) : IMovieGetIdUseCase {

    override suspend fun getIdMovie(imdbID: String): MovieEntity? {
        val resultImdbID = iDMovieAbstract.getIdMovieRepository(imdbID)
        resultImdbID?.let {
            return resultImdbID
        } ?: run {
            return null
        }
    }
}
