package com.example.squadmovies.domain.abstracts

import com.example.squadmovies.data.dao.MovieEntity
import com.example.squadmovies.domain.entities.MovieDomainEntities

interface IMovieGetIdMovieAbstract {

    suspend fun getIdMovieRepository(imdbID: String): MovieDomainEntities?
}
