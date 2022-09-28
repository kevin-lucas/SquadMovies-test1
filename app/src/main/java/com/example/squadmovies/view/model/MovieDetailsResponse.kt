package com.example.squadmovies.view.model

import com.google.gson.annotations.SerializedName

class MovieDetailsResponse(

    @SerializedName("Poster")
    val poster: String,

    @SerializedName("Plot")
    val plot: String,

    @SerializedName("Language")
    val language: String,

    @SerializedName("Search")
    val movies: List<MovieResponse>


)
