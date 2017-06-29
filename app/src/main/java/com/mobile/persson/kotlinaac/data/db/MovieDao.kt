package com.mobile.persson.kotlinaac.data.db

import com.mobile.persson.kotlinaac.data.db.model.MovieModel
import com.vicpin.krealmextensions.*
import io.reactivex.Flowable
import io.reactivex.Single
import io.reactivex.internal.operators.flowable.FlowableConcatMap
import io.realm.Realm
import io.realm.RealmResults
import rx.functions.Func1
import java.util.*


/**
 * Created by luizfelipepersson on 26/06/17.
 */
class MovieDao {
    fun insertMovie(movie: MovieModel) = movie.save()

    fun insertMovies(movies: List<MovieModel>) = movies.saveAll()

    fun getAllMovies(): Single<List<MovieModel>>
            = Single.fromCallable<List<MovieModel>> {
        Realm.getDefaultInstance().use {
            realm ->
            return@fromCallable realm.copyFromRealm<MovieModel>(realm.where(MovieModel::class.java).findAll())
        }
    }
    //MovieModel().queryAll()

    fun deleteAll() = MovieModel().deleteAll()

}
