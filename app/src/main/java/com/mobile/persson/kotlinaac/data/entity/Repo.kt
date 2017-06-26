package com.mobile.persson.kotlinaac.data.entity

import com.google.gson.annotations.SerializedName

/**
 * Created by luizfelipepersson on 21/06/17.
 */
data class Repo(
        @SerializedName("results")
        var movies: List<Movie>)

class Movie(
        @SerializedName("poster_path") val posterPath: String,
        val id: String,
        val overview: String,
        val title: String)

