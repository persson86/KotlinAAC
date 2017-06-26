package com.mobile.persson.kotlinaac.repository.model

import com.google.gson.annotations.SerializedName

/**
 * Created by luizfelipepersson on 21/06/17.
 */
data class Repo(var id: Int = 0) {
    @SerializedName("results")
    lateinit var movies: List<Movie>
}

data class Owner(
        @SerializedName("login") val login: String
)

class Movie(
        @SerializedName("poster_path") val posterPath: String,
        val id: String,
        val overview: String,
        val backdropPath: String,
        val title: String)
