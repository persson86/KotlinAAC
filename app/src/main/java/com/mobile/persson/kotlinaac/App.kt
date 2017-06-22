package com.mobile.persson.kotlinaac

import android.app.Application
import com.mobile.persson.kotlinaac.repository.db.DatabaseCreator

/**
 * Created by luizfelipepersson on 22/06/17.
 */
class App : Application() {

    override fun onCreate() {
        super.onCreate()
        DatabaseCreator.createDb(this)
    }
}