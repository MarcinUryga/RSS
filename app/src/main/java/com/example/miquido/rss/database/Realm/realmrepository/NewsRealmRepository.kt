package com.example.miquido.rss.database.Realm.realmrepository

import android.content.Context


import com.example.miquido.rss.database.MapperToNews
import com.example.miquido.rss.database.Realm.NewsRealm
import com.example.miquido.rss.database.pojo.News

import java.util.ArrayList

import io.realm.Realm
import io.realm.RealmConfiguration
import io.realm.RealmResults

/**
 * Created by marci on 2017-07-16.
 */

class NewsRealmRepository(context: Context) : Repository<News> {

    private val realmConfiguration: RealmConfiguration
    internal var realm: Realm

    init {
        this.realmConfiguration = RealmConfiguration.Builder(context).build()
        realm = Realm.getInstance(realmConfiguration)
    }

    override fun add(item: News) {
        val realm = Realm.getInstance(realmConfiguration)

        realm.executeTransaction { realm ->
            val newsRealm = realm.createObject(NewsRealm::class.java)
            newsRealm.id = generateId()
            newsRealm.newsTitle = item.newsTitle
            newsRealm.newsDate = item.newsDate
            newsRealm.newsContent = item.newsContent
        }

        realm.close()
    }

    private fun generateId(): Int {
        return realm.where(NewsRealm::class.java).max("id").toInt() + 1
    }


    override fun add(items: Iterable<News>) {

    }

    override fun update(item: News) {

    }

    override fun remove(item: News) {

    }

    override fun remove(specification: Specification) {

    }

    override fun query(specification: Specification): List<News> {
        val realmSpecification = specification as RealmSpecification

        val realm = Realm.getInstance(realmConfiguration)
        val realmResults = realmSpecification.toRealmResults(realm)

        val newses = ArrayList<News>()

        for (news in realmResults) {
            newses.add(MapperToNews.fromRealm(news))
        }

        realm.close()

        return newses
    }
}
