package com.mobile.persson.kotlinaac.repository

import android.util.Log
import com.mobile.persson.kotlinaac.data.LocalDataSource
import com.mobile.persson.kotlinaac.data.RemoteDataSource
import com.mobile.persson.kotlinaac.data.entity.Repo
import io.reactivex.Single
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

/**
 * Created by luizfelipepersson on 21/06/17.
 */
class MainRepository : RepositoryDataSource {

    private val remoteDataSource = RemoteDataSource.Factory.create()
    private val localDataSource = LocalDataSource()

    override fun getRepos(): Single<List<Repo>>
            = localDataSource
            .getRepos()
            .doOnSuccess { Log.v("LFSP", "Local GET OK") }
            .doOnError { Log.v("LFSP", "Local GET NOK") }
            .onErrorResumeNext {
                remoteDataSource.getRepos()
                        .doOnSuccess {
                            localDataSource.saveRepositories(it)
                            Log.v("LFSP", "Remote GET OK")
                        }
                        .doOnError { Log.v("LFSP", "Remote GET NOK") }
            }
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
}
