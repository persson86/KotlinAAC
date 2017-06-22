package com.mobile.persson.kotlinaac.data.db.dao

import android.arch.persistence.room.Dao
import android.arch.persistence.room.Insert
import android.arch.persistence.room.OnConflictStrategy
import android.arch.persistence.room.Query
import com.mobile.persson.kotlinaac.data.entity.Repo
import io.reactivex.Flowable


/**
 * Created by luizfelipepersson on 22/06/17.
 */
@Dao
interface ReposDao {

    @Query("SELECT * FROM repos")
    fun loadAllRepos(): Flowable<List<Repo>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertRepos(repo: MutableList<Repo>)

}