package com.mobile.persson.kotlinaac.data.entity

import com.google.gson.annotations.SerializedName

/**
 * Created by luizfelipepersson on 23/06/17.
 */
class MovieResponse {
    var id: Int? = 0
    var page: Int? = 0
    var results: List<String>? = null
}