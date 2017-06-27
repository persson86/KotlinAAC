package com.mobile.persson.kotlinaac.repository

import android.util.Log
import com.mobile.persson.kotlinaac.data.LocalDataSource
import com.mobile.persson.kotlinaac.data.RemoteDataSource
import com.mobile.persson.kotlinaac.data.db.MovieDao
import com.mobile.persson.kotlinaac.data.db.model.MovieModel
import com.mobile.persson.kotlinaac.data.response.Movies
import io.reactivex.Single
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

/**
 * Created by luizfelipepersson on 21/06/17.
 */
class MainRepository : RepositoryDataSource {

    private val remoteDataSource = RemoteDataSource.Factory.create()
    private val localDataSource = LocalDataSource()
    private val test = MovieDao()

    override fun getRepos(): Single<List<Movies>>
            = /*localDataSource
            .getRepos()
            .doOnSuccess { Log.v("LFSP", "Local GET OK") }
            .doOnError { Log.v("LFSP", "Local GET NOK") }
            .onErrorResumeNext {*/
            remoteDataSource.getRepos()
                    .doOnSuccess {
                        //localDataSource.saveRepositories(it)
                        Log.v("LFSP", "Remote GET OK")
                    }
                    .doOnError { Log.v("LFSP", "Remote GET NOK") }
                    //}
                    .subscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread())

    override fun getRepos2(): Single<Movies>
            = remoteDataSource.getRepos2()
            .doOnSuccess {
                val movies: MutableList<MovieModel> = java.util.ArrayList()
                it.movies.forEach {
                    val movie: MovieModel = MovieModel()
                    movie.title = it.title
                    movies.add(movie)
                }


                test.deleteAll()
                test.insertMovies(movies)
                val listTest: List<MovieModel> = test.getAllMovies()

                Log.v("LFSP", "SUCESSO 2")

            }
            .doOnError { Log.v("LFSP", "ERORR 2") }
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())

}
