package com.mobile.persson.kotlinaac.data.db

import com.mobile.persson.kotlinaac.data.db.model.MovieModel
import com.vicpin.krealmextensions.*
import io.realm.Realm


/**
 * Created by luizfelipepersson on 26/06/17.
 */
class MovieDao {
    fun insertMovie(movie: MovieModel) = movie.save()

    fun insertMovies(movies: List<MovieModel>) = movies.saveAll()

    fun getAllMovies(): List<MovieModel> = MovieModel().queryAll()

    fun deleteAll() = MovieModel().deleteAll()

    fun insertMovies2(movies: List<MovieModel>){
        val realm: Realm = Realm.getDefaultInstance()
        realm.copyToRealmOrUpdate(movies)
    }
}