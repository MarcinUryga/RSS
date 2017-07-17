package com.example.miquido.rss.database

import com.example.miquido.rss.database.Realm.NewsRealm
import com.example.miquido.rss.database.pojo.News


/**
 * Created by marci on 2017-07-02.
 */

object MapperToNews {
    fun fromRealm(newsRealm: NewsRealm): News {
        val news = News()
        news.id = newsRealm.id
        news.newsTitle = newsRealm.newsTitle
        return news
    }
}
