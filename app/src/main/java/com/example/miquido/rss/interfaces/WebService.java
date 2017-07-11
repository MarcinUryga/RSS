package com.example.miquido.rss.interfaces;

import android.telecom.Call;

import com.example.miquido.rss.Model.RSSObject;

import retrofit.Callback;
import retrofit.http.GET;

/**
 * Created by miquido on 11.07.2017.
 */

public interface WebService {

    @GET("/services/xml/rss/nyt/Science.xml")
    void getScienceData(Callback<RSSObject> pResponse);

    @GET("/services/xml/rss/nyt/Europe.xml")
    void getEuropeNewsData(Callback<RSSObject> pResponse);

    @GET("/services/xml/rss/nyt/Technology.xml")
    void getTechnologyData(Callback<RSSObject> pResponse);
}
