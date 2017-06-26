package com.mobile.persson.kotlinaac.ui.main

import android.arch.lifecycle.MediatorLiveData
import com.mobile.persson.kotlinaac.repository.Repository
import com.mobile.persson.kotlinaac.repository.model.Repo
import io.reactivex.disposables.Disposable

/**
 * Created by luizfelipepersson on 21/06/17.
 */
class MainLiveData(repository: Repository) : MediatorLiveData<Pair<Repo?, Throwable?>>() {

    private var disposable: Disposable? = null

/*    init {
        disposable = repository
                .getRepos()
                .subscribe { data, error -> this@MainLiveData.value = Pair(data, error) }*/


    init {
        disposable = repository
                .getRepos2()
                .subscribe { data, error -> this@MainLiveData.value = Pair(data, error) }
    }

    override fun onInactive() {
        super.onInactive()
        if (disposable?.isDisposed?.not() ?: false) {
            disposable?.dispose()
        }
    }
}