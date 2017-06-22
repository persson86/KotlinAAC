package com.mobile.persson.kotlinaac.repository

import com.mobile.persson.kotlinaac.repository.entity.Repo
import io.reactivex.Single

/**
 * Created by luizfelipepersson on 21/06/17.
 */
interface RepositoryDataSource {

    fun getRepos(): Single<List<Repo>>

    fun saveRepositories(list: List<Repo>): Unit = Unit
}