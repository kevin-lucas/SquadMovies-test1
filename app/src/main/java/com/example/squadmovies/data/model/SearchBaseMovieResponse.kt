package com.example.squadmovies.data.model

import com.google.gson.annotations.SerializedName

data class SearchBaseMovieResponse(
    @SerializedName("Search")
    val movies: List<MovieResponse>,

    @SerializedName("Response")
    val statusResponse: String,

    @SerializedName("Error")
    val errorMessage: String
)
