package com.example.squadmovies.view.model

import com.google.gson.annotations.SerializedName

class MovieResponse(
    @SerializedName("Title")
    val title: String,

    @SerializedName("Year")
    val year: String,

    @SerializedName("Poster")
    val poster: String

)
