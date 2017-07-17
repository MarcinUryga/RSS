package com.example.miquido.rss.database.Realm.realmrepository;

import java.util.List;

/**
 * Created by marci on 2017-07-16.
 */

public interface Repository<T> {
    void add(T item);

    void add(Iterable<T> items);

    void update(T item);

    void remove(T item);

    void remove(Specification specification);

    List<T> query(Specification specification);

}
