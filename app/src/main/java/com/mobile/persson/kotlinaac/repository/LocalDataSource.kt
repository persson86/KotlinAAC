package com.mobile.persson.kotlinaac.repository

import android.util.Log
import com.mobile.persson.kotlinaac.repository.db.DatabaseCreator
import com.mobile.persson.kotlinaac.repository.entity.Repo
import io.reactivex.Single

/**
 * Created by luizfelipepersson on 22/06/17.
 */
class LocalDataSource : RepositoryDataSource {

    val reposDao = DatabaseCreator.database.reposDao()

    override fun getRepos(): Single<List<Repo>>
            = reposDao
            .loadAllRepos()
            .firstOrError()
            .doOnSuccess {
                if (it.isEmpty()) throw Exception() else (Log.v("LFSP", "Local GET Ok!"))
            }
            .doOnError { Log.v("LFSP", "Local GET NOK") }

    override fun saveRepositories(list: List<Repo>)
            = reposDao.insertRepos(list.toMutableList())

}