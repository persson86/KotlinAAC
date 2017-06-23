package com.mobile.persson.kotlinaac.data.entity

import android.arch.persistence.room.Embedded
import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey
import com.google.gson.annotations.SerializedName

/**
 * Created by luizfelipepersson on 21/06/17.
 */
@Entity(tableName = "repos")
class Repo {
    @PrimaryKey(autoGenerate = true)
    var id: Long? = 0

    var page: Int? = 0
    /*@SerializedName("results")
    lateinit var results: List<Movie>*/
    //var total_results: Int? = 0
    //var total_pages: Int? = 0

}

class Movie(
        var id: String? = "",
        var title: String? = "")

