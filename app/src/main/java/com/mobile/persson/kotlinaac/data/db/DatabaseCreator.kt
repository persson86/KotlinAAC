package com.mobile.persson.kotlinaac.data.db

import android.arch.lifecycle.MutableLiveData
import android.arch.persistence.room.Room.databaseBuilder
import android.content.Context
import io.reactivex.Completable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import java.util.concurrent.atomic.AtomicBoolean

/**
 * Created by luizfelipepersson on 22/06/17.
 */
object DatabaseCreator {

    val isDatabaseCreated = MutableLiveData<Boolean>()

    lateinit var database: AppDatabase

    private val mInitializing = AtomicBoolean(true)

    fun createDb(context: Context) {
        if (DatabaseCreator.mInitializing.compareAndSet(true, false).not()) {
            return
        }

        DatabaseCreator.isDatabaseCreated.value = false

        Completable.fromAction {
            DatabaseCreator.database = databaseBuilder(context, AppDatabase::class.java, AppDatabase.Companion.DATABASE_NAME).build()
        }
                .subscribeOn(Schedulers.computation())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({ DatabaseCreator.isDatabaseCreated.value = true }, { it.printStackTrace() })
    }
}