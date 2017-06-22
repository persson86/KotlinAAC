package com.mobile.persson.kotlinaac.data

import com.mobile.persson.kotlinaac.BuildConfig.API_END_POINT
import com.mobile.persson.kotlinaac.data.entity.Repo
import io.reactivex.Single
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory

/**
 * Created by luizfelipepersson on 21/06/17.
 */
interface RemoteDataSource {
    @retrofit2.http.GET("users/persson86/repos")
    fun getRepos(): Single<List<Repo>>

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
