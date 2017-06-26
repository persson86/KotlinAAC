package com.mobile.persson.kotlinaac.data

import com.mobile.persson.kotlinaac.data.entity.Repo
import com.mobile.persson.kotlinaac.repository.RepositoryDataSource
import io.reactivex.Single

/**
 * Created by luizfelipepersson on 22/06/17.
 */
class LocalDataSource {//: RepositoryDataSource {

    /*val reposDao = DatabaseCreator.database.reposDao()

    override fun getRepos(): Single<List<Repo>>
            = reposDao
            .loadAllRepos()
            .firstOrError()
            .doOnSuccess {
                if (it.isEmpty()) throw Exception()
            }

    override fun saveRepositories(list: List<Repo>)
            = reposDao.insertRepos(list.toMutableList())
*/
}