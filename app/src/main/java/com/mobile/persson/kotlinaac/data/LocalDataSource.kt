package com.mobile.persson.kotlinaac.data

import com.mobile.persson.kotlinaac.data.db.MovieDao
import com.mobile.persson.kotlinaac.data.db.model.MovieModel
import com.mobile.persson.kotlinaac.data.response.Movies
import com.mobile.persson.kotlinaac.repository.RepositoryDataSource
import io.reactivex.Observable
import io.reactivex.Single

/**
 * Created by luizfelipepersson on 22/06/17.
 */
class LocalDataSource{ /*: RepositoryDataSource {

    val movieDao = MovieDao()

    override fun getReposLocal(): Single<List<MovieModel>>
            = movieDao
            .getAllMovies()

    override fun getRepos(): Single<List<Movies>> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun getRepos2(): Single<Movies> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }*/

/*
    override fun getRepositories(organization: String): Single<List<Repo>>
            = reposDao
            .loadAllRepos(organization)
            .firstOrError()
            .doOnSuccess { if (it.isEmpty()) throw Exception() }
*/


/*    override fun saveRepositories(list: List<Repo>)
            = reposDao.insertRepos(list.toMutableList())*/
}