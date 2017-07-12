package com.example.miquido.rss.Common;

import com.example.miquido.rss.Model.RSSObject;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

/**
 * Created by miquido on 11.07.2017.
 */

public class LinksJava {
    public final static String SCIENCE_NEWS_LINK = "/services/xml/rss/nyt/Science.xml";
    public final static String SPORT_NEWS_LINK = "/services/xml/rss/nyt/Europe.xml";
    public final static String TECHNOLOGY_NEWS_LINK = "/services/xml/rss/nyt/Technology.xml";

}
