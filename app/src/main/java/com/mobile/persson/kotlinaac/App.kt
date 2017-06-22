package com.mobile.persson.kotlinaac

import android.app.Application
import io.realm.Realm

/**
 * Created by luizfelipepersson on 22/06/17.
 */
class App : Application() {
    override fun onCreate() {
        super.onCreate()
        Realm.init(this)
    }
}