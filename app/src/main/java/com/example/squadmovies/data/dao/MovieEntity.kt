package com.example.squadmovies.data.dao

import androidx.room.Entity
import androidx.room.Index
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName
import java.io.Serializable

// Classe com anotacao que descreve uma tabela de banco de dados ao trabalhar com room
@Entity(
    tableName = "movie",
    indices = [
        Index(value = ["title", "imdbID"], unique = true)
    ]

)
data class MovieEntity(
    @PrimaryKey(autoGenerate = true)

    @SerializedName("imdbID")
    val imdbID: String?,
    @SerializedName("Title")
    val title: String,
    @SerializedName("Year")
    val year: String,
    @SerializedName("Poster")
    val poster: String?,
    @SerializedName("Plot")
    val plot: String,
    @SerializedName("Language")
    val language: String?,
    @SerializedName("Response")
    val response: String? = ""

) : Serializable
