package com.mobile.persson.kotlinaac.ui.main

import android.arch.lifecycle.MediatorLiveData
import com.mobile.persson.kotlinaac.repository.MainRepository
import com.mobile.persson.kotlinaac.data.entity.Repo
import io.reactivex.disposables.Disposable

/**
 * Created by luizfelipepersson on 21/06/17.
 */
class MainLiveData(repository: MainRepository) : MediatorLiveData<Pair<Repo?, Throwable?>>() {

    private var disposable: Disposable? = null

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