package com.mobile.persson.kotlinaac.repository.entity

import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey
import com.google.gson.annotations.SerializedName

/**
 * Created by luizfelipepersson on 21/06/17.
 */
@Entity(tableName = "repos")
data class Repo (
        @PrimaryKey(autoGenerate = true)
        var id: Long? = 0,
        var name: String? = "",
        var full_name: String? = "",
        var description: String? = "")
        //var owner: Owner)

data class Owner(
        @SerializedName("login") var login: String? = ""
)

