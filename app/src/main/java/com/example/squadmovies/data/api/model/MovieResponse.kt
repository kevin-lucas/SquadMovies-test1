package com.example.squadmovies.projeto.model

import com.google.gson.annotations.SerializedName
import java.io.Serializable

class MovieResponse(
    @SerializedName("Title")
    val title: String,

    @SerializedName("Year")
    val year: String,

    @SerializedName("Poster")
    val poster: String,

    @SerializedName("Plot")
    val plot: String,

    @SerializedName("Language")
    val language: String,

    @SerializedName("imdbID")
    val imdbID: String,

    @SerializedName("Response")
    val response: String? = "True"

) : Serializable