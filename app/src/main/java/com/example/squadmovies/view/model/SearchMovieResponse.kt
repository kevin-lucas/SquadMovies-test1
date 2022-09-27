package com.example.squadmovies.view.model

import com.google.gson.annotations.SerializedName

class SearchMovieResponse(
    @SerializedName("Search")
    val movies: List<MovieResponse>
)
