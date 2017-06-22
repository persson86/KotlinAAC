package com.mobile.persson.kotlinaac.repository.model

import com.google.gson.annotations.SerializedName
import io.realm.RealmModel
import io.realm.RealmObject
import io.realm.annotations.PrimaryKey

/**
 * Created by luizfelipepersson on 21/06/17.
 */
open class Repo (
        @PrimaryKey()
        var id: Long = 0,
        var name: String = "",
        var full_name: String = "",
        var description: String = "") : RealmObject()

data class Owner(
        @SerializedName("login") val login: String
)
