package com.mobile.persson.kotlinaac.repository

import com.mobile.persson.kotlinaac.repository.model.Repo
import io.reactivex.Flowable
import io.reactivex.Single
import io.realm.Realm
import io.realm.RealmResults

/**
 * Created by luizfelipepersson on 22/06/17.
 */
class LocalDataSource : RepositoryDataSource {

    val realm = Realm.getDefaultInstance()

    override fun getRepos(): Single<List<Repo>> {
        val realmResults = realm.where(Repo::class.java).findAll()
        val singleListRepo: Single<List<Repo>> = realm.copyFromRealm(realmResults)

        return singleListRepo
    }

}

/*interface Repository {
    fun getUserList(query:String): Observable<List<UserModel>>
}*/

