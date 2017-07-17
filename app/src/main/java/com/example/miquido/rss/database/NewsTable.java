package com.example.miquido.rss.database;

/**
 * Created by marci on 2017-07-02.
 */

public interface NewsTable {
    String TABLE_NAME = "News_table";

    interface Columns{
    //    String NEWS_ID = "_id";
        String NEWS_TITLE = "news_title";
        String NEWS_DATE = "news_date";
        String NEWS_CONTENT = "news_content";

    }
}
