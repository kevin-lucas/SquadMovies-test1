package com.example.squadmovies.data.dao

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

//@Database(entities = [MovieEntity::class.java], version = 1)
abstract class MovieDataBase : RoomDatabase() {

    abstract val iMovieDAO: IMovieDAO

    companion object {
        @Volatile
        private var INSTANCE: MovieDataBase? = null
        fun getInstance(context: Context): MovieDataBase {
            synchronized(this) {
                var instance: MovieDataBase? = INSTANCE
                if (instance == null) {
                    instance = Room.databaseBuilder(
                        context,
                        MovieDataBase::class.java,
                        "SquadMovies"
                    ).build()
                }
                return instance
            }
        }
    }
}
