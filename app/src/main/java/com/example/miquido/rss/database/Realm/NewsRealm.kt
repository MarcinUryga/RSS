package com.example.miquido.rss.database.Realm

import io.realm.RealmObject
import io.realm.annotations.PrimaryKey
import io.realm.annotations.RealmClass


/**
 * Created by marci on 2017-07-02.
 */

@RealmClass
open class NewsRealm : RealmObject(){
    @PrimaryKey
    var newsId: Int
    var newsURL: String
    var newsTitle: String
    var newsDate: String
    var newsContent: String

    init {
        newsId = 0
        newsURL = ""
        newsTitle = ""
        newsDate = ""
        newsContent = ""
    }
}
