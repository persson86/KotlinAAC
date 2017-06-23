package com.mobile.persson.kotlinaac.data.db

import android.arch.persistence.room.RoomDatabase
import com.mobile.persson.kotlinaac.data.db.dao.ReposDao
import com.mobile.persson.kotlinaac.data.entity.Repo

/**
 * Created by luizfelipepersson on 22/06/17.
 */
@android.arch.persistence.room.Database(entities = arrayOf(Repo::class), version = 1)
abstract class AppDatabase : RoomDatabase() {

    abstract fun reposDao(): ReposDao

    companion object {
        const val DATABASE_NAME = "kotlin_acc-db"
    }

}