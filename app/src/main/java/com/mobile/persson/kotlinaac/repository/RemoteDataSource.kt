package com.mobile.persson.kotlinaac.repository

import com.mobile.persson.kotlinaac.BuildConfig.API_END_POINT
import com.mobile.persson.kotlinaac.repository.model.Repo
import io.reactivex.Single
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.http.GET
import retrofit2.http.QueryMap

/**
 * Created by luizfelipepersson on 21/06/17.
 */
interface RemoteDataSource {
    @retrofit2.http.GET("discover/movie?api_key=6bbb854c2d718fdef1ea092e0f99f070&language=en-US&sort_by=popularity.desc&include_adult=false&include_video=false&page=1")
    fun getRepos(): Single<List<Repo>>

    @retrofit2.http.GET("discover/movie?api_key=6bbb854c2d718fdef1ea092e0f99f070&language=en-US&sort_by=popularity.desc&include_adult=false&include_video=false&page=1")
    fun getRepos2(): Single<Repo>

    companion object Factory {
        fun create(): RemoteDataSource {
            val retrofit = retrofit2.Retrofit.Builder()
                    .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                    .addConverterFactory(retrofit2.converter.gson.GsonConverterFactory.create())
                    .baseUrl(API_END_POINT)
                    .build()

            return retrofit.create(RemoteDataSource::class.java)
        }
    }
}
