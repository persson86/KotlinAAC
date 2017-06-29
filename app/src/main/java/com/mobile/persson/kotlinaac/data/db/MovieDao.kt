package com.mobile.persson.kotlinaac.data.db

import com.mobile.persson.kotlinaac.data.db.model.MovieModel
import com.vicpin.krealmextensions.*
import io.reactivex.Flowable
import io.reactivex.Single
import io.realm.Realm
import io.realm.RealmResults
import rx.functions.Func1


/**
 * Created by luizfelipepersson on 26/06/17.
 */
interface MovieDao {
    fun insertMovie(movie: MovieModel) = movie.save()

    fun insertMovies(movies: List<MovieModel>) = movies.saveAll()

    fun getAllMovies(): List<MovieModel> = MovieModel().queryAll()

    fun deleteAll() = MovieModel().deleteAll()

    fun getAllMovies2(): Single<List<MovieModel>>
}

class test : MovieDao {
    override fun getAllMovies2(): Single<List<MovieModel>> {
        return MovieModel().queryAllAsync {

        }
    }
}