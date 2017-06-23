package com.mobile.persson.kotlinaac.repository

import android.util.Log
import com.mobile.persson.kotlinaac.data.LocalDataSource
import com.mobile.persson.kotlinaac.data.RemoteDataSource
import com.mobile.persson.kotlinaac.data.entity.MovieResponse
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
    //TODO import from R.strings
    private val apiKey = "6bbb854c2d718fdef1ea092e0f99f070"

    override fun getRepos(): Single<List<Repo>>
            = /*localDataSource
            .getRepos()
            .doOnSuccess { Log.v("LFSP", "Local GET OK") }
            .doOnError { Log.v("LFSP", "Local GET NOK") }
            .onErrorResumeNext {*/
            remoteDataSource.getMovies(apiKey, 1, "en-US")
                    .doOnSuccess {
                        //localDataSource.saveRepositories(it)
                        Log.v("LFSP", "Remote GET OK")
                    }
                    .doOnError { Log.v("LFSP", "Remote GET NOK") }

                    .subscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread())
}
