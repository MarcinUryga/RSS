package com.example.miquido.rss.database

import com.example.miquido.rss.Model.Item
import com.example.miquido.rss.Model.RSSObject
import com.example.miquido.rss.database.Realm.NewsRealm
import com.example.miquido.rss.database.pojo.News


/**
 * Created by marci on 2017-07-02.
 */

object MapperToNews {
    fun fromRealm(newsRealm: NewsRealm): News {
        return News(newsRealm.newsTitle,
                    newsRealm.newsDate,
                    newsRealm.newsContent)
    }

    fun fromItem(item: Item): News {
        return News(item.title, item.pubDate, item.content)
    }
}
