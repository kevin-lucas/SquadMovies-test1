package com.example.squadmovies.view.model

import com.google.gson.annotations.SerializedName

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

    @SerializedName("Search")
    val movies: List<MovieResponse>

)
