package com.mobile.persson.kotlinaac.repository

import com.mobile.persson.kotlinaac.repository.model.Repo
import io.reactivex.Flowable

/**
 * Created by luizfelipepersson on 22/06/17.
 */
interface ReposDao {
    fun loadAllRepos(): Flowable<List<Repo>>
}