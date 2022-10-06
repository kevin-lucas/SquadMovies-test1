package com.example.squadmovies.data.dao

import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

interface IMovieDAO {

// Criando o DAO fornece consultas

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(movie: MovieEntity): String

    @Query("SELECT * FROM movie")
    suspend fun allMovie(): List<MovieEntity>

    @Query("SELECT * FROM movie WHERE imdbID =:imdbID")
    suspend fun getByImdbId(imdbID: String): MovieEntity?

    @Query("DELETE FROM movie WHERE title = :imdbID")
    suspend fun delete(imdbID: String)
}
