package com.example.miquido.rss.database.Realm.realmrepository


import com.example.miquido.rss.database.Realm.NewsRealm

import io.realm.Realm
import io.realm.RealmResults

/**
 * Created by marci on 2017-07-16.
 */

class GetAllNewsesSpecification : RealmSpecification {

    override fun toRealmResults(realm: Realm): RealmResults<NewsRealm> {
        return realm.where(NewsRealm::class.java).findAll()
    }
}