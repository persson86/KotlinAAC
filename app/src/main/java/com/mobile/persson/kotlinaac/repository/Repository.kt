package com.mobile.persson.kotlinaac.repository

import android.util.Log
import com.mobile.persson.kotlinaac.repository.model.Repo
import io.reactivex.Single
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

/**
 * Created by luizfelipepersson on 21/06/17.
 */
class Repository : RepositoryDataSource {

    val remoteDataSource = RemoteDataSource.Factory.create()
    val localDataSource = LocalDataSource()

    override fun getRepos(): Single<List<Repo>>
            = localDataSource.getRepos()
            .onErrorResumeNext {
                remoteDataSource.getRepos()
                        .doOnSuccess { Log.v("LFSP", "SUCESSO") }
                        .doOnError { Log.v("LFSP", "ERORR") }
            }
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
}