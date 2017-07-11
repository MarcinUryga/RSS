package com.example.miquido.rss.Common

/**
 * Created by miquido on 11.07.2017.
 */
public object Links {
    val RSS_link = "http://rss.nytimes.com/services/xml/rss/nyt/Science.xml"
    val RSS_to_JSON_API = "https://api.rss2json.com/v1/api.json?rss_url="

    val RETROFIT_RSS_ENDPOINT_API = "https://api.rss2json.com/v1/api.json?rss_url=http://rss.nytimes.com"

    val SCIENCE_NEWS_LINK = "/services/xml/rss/nyt/Science.xml"
    val EUROPEAN_NEWS_LINK = "/services/xml/rss/nyt/Europe.xml"
    val TECHNOLOGY_NEWS_LINK = "/services/xml/rss/nyt/Technology.xml"
}