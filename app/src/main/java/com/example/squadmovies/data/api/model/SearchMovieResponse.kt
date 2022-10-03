package com.example.squadmovies.projeto.model

import com.google.gson.annotations.SerializedName

class SearchMovieResponse(
    @SerializedName("Search")
    val movies: List<MovieResponse>,

    @SerializedName("Response")
    val statusResponse: String,

    @SerializedName("Error")
    val errorMessage: String = ""
)
