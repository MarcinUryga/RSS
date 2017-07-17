package com.example.miquido.rss.WebServices;

import com.example.miquido.rss.Model.RSSObject;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by miquido on 11.07.2017.
 */

public interface WebService {

    @GET("api.json/")
    Call<RSSObject> listNews(@Query("rss_url") String link);

    /*
    @GET("/services/xml/rss/nyt/Science.xml")
    void getScienceNewsData(Callback<RSSObject> pResponse);

    @GET("/services/xml/rss/nyt/Europe.xml")
    void getEuropeNewsData(Callback<RSSObject> pResponse);

    @GET("/services/xml/rss/nyt/Technology.xml")
    void getTechnologyData(Callback<RSSObject> pResponse);
*/
}
