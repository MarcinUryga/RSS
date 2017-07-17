package com.example.miquido.rss.database.Realm.realmrepository


import com.example.miquido.rss.database.Realm.NewsRealm

import io.realm.Realm
import io.realm.RealmResults

/**
 * Created by marci on 2017-07-16.
 */

interface RealmSpecification : Specification {
    fun toRealmResults(realm: Realm): RealmResults<NewsRealm>
}
