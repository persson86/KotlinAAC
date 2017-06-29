package com.mobile.persson.kotlinaac.repository

import com.mobile.persson.kotlinaac.data.db.model.MovieModel
import com.mobile.persson.kotlinaac.data.response.Movies
import io.reactivex.Single

/**
 * Created by luizfelipepersson on 21/06/17.
 */
interface RepositoryDataSource {

    fun getRepos(): Single<List<Movies>>
    //fun saveRepositories(list: List<Repo>): Unit = Unit
    fun getRepos2(): Single<Movies>

    fun getReposLocal(): Single<List<MovieModel>>
}