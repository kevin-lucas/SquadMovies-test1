package com.example.squadmovies.domain.abstracts

import com.example.squadmovies.domain.entities.Movie


interface IMovieGetIdMovieAbstract {

     suspend fun getIdMovieRepository(imdbID: String): Movie?
}
