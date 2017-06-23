package com.mobile.persson.kotlinaac.ui.main

import android.app.Application
import android.arch.lifecycle.AndroidViewModel
import android.arch.lifecycle.MediatorLiveData
import com.mobile.persson.kotlinaac.repository.MainRepository
import com.mobile.persson.kotlinaac.data.entity.Repo

/**
 * Created by luizfelipepersson on 21/06/17.
 */
class MainViewModel(application: Application?) : AndroidViewModel(application) {

    private val repository = MainRepository()
    val resultLiveData = MainLiveData(repository)
    val throwableLiveData = MediatorLiveData<Throwable>()
    val reposLiveData = MediatorLiveData<List<Repo>>()

    init {
        throwableLiveData.addSource(resultLiveData) {
            it?.second?.let { throwableLiveData.value = it }
        }
    }

    init {
        reposLiveData.addSource(resultLiveData) {
            it?.first?.let { reposLiveData.value = it }
        }
    }
}