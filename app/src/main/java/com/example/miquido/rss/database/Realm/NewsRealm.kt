package com.example.miquido.rss.database.Realm

import io.realm.RealmObject
import io.realm.annotations.PrimaryKey


/**
 * Created by marci on 2017-07-02.
 */

open class NewsRealm : RealmObject(){
    var newsTitle: String
    var newsDate: String
    var newsContent: String

    init {
        newsTitle = ""
        newsDate = ""
        newsContent = ""
    }
}
