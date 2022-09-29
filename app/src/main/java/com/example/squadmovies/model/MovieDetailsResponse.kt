package com.example.squadmovies.projeto.model

import com.google.gson.annotations.SerializedName

class MovieDetailsResponse(

    @SerializedName("Poster")
    val poster: String,

    @SerializedName("Plot")
    val plot: String,

    @SerializedName("Language")
    val language: String,

    @SerializedName(" ")
    val imdbID: String

)
