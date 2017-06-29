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
    private val localDataSource2 = LocalDataSource()
    private val localDataSource = MovieDao()

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

    override fun getRepos2(): Single<Movies> {

        //val localMovies = localDataSource.getAllMovies()
        //if (localMovies.isEmpty()) {



            val localMovies = localDataSource.getAllMovies()

            val remoteMovies =  remoteDataSource.getRepos2()
                    .doOnSuccess {
                        val movies: MutableList<MovieModel> = java.util.ArrayList()
                        val movie = MovieModel()
                        it.movies.forEach {
                            movie.title = it.title
                            movies.add(movie)
                        }

                        localDataSource.deleteAll()
                        localDataSource.insertMovies(movies)
                        Log.v("LFSP", "SUCESSO 2")

                    }
                    .doOnError { Log.v("LFSP", "ERORR 2") }
                    .subscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread())



        return remoteMovies

    }

    override fun getReposLocal(): Single<List<MovieModel>> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}
