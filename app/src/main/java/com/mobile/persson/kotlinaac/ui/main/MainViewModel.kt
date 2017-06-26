package com.mobile.persson.kotlinaac.ui.main

import android.app.Application
import android.arch.lifecycle.AndroidViewModel
import android.arch.lifecycle.MediatorLiveData
import android.arch.lifecycle.MutableLiveData
import com.mobile.persson.kotlinaac.repository.Repository
import com.mobile.persson.kotlinaac.repository.model.Repo

/**
 * Created by luizfelipepersson on 21/06/17.
 */
class MainViewModel(application: Application?) : AndroidViewModel(application) {

    private val repository = Repository()
    val resultLiveData = MainLiveData(repository)
    val throwableLiveData = MediatorLiveData<Throwable>()
    val reposLiveData = MediatorLiveData<List<Repo>>()
    val reposLiveData2 = MediatorLiveData<Repo>()

    init {
        throwableLiveData.addSource(resultLiveData) {
            it?.second?.let { throwableLiveData.value = it }
        }
    }

    init {
        reposLiveData2.addSource(resultLiveData) {
            it?.first?.let { reposLiveData2.value = it }
        }
    }
}