package com.example.miquido.rss.database.Realm.realmrepository

import com.example.miquido.rss.database.NewsTable
import com.example.miquido.rss.database.Realm.NewsRealm
import com.example.miquido.rss.database.pojo.News

import io.realm.Realm
import io.realm.RealmResults

/**
 * Created by marci on 2017-07-16.
 */
/*
class NewsByIdSpecification(private val id: Int) : RealmSpecification, CacheSpecification<News> {

    override fun toRealmResults(realm: Realm) {
        return
        /*realm.where(NewsRealm::class.java)
                .equalTo(NewsTable.Columns.NEWS_ID, id)
                .findAll()*/
    }

    override fun accept(item: News): Boolean {
        //return id == item.id
    }
}
*/