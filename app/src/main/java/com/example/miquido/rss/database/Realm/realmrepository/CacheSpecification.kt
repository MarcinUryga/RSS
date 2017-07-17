package com.example.miquido.rss.database.Realm.realmrepository

/**
 * Created by marci on 2017-07-17.
 */
interface CacheSpecification<T> : Specification {
    fun accept(item: T): Boolean
}
