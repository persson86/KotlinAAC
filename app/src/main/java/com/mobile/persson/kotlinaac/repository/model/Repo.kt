package com.mobile.persson.kotlinaac.repository.model

import com.google.gson.annotations.SerializedName

/**
 * Created by luizfelipepersson on 21/06/17.
 */
data class Repo(
        val name: String?,
        val full_name: String?,
        val description: String?,
        val owner: Owner)

data class Owner(
        @SerializedName("login") val login: String
)
