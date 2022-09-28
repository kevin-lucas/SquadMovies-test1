package com.example.squadmovies.adapter.model

import com.google.gson.annotations.SerializedName

class SearchMovieResponse(
    @SerializedName("Search")
    val movies: List<MovieResponse>
)
