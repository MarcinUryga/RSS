package com.example.miquido.rss.WebServices

import com.example.miquido.rss.Common.Links
import com.example.miquido.rss.Model.RSSObject
import com.example.miquido.rss.database.MapperToNews
import com.example.miquido.rss.database.pojo.News

import com.example.miquido.rss.interfaces.CallbackRSS
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

/**
 * Created by marci on 2017-07-11.
 */
class NewsFromWebServiceController(private val link: String,
                                   private val callback: CallbackRSS) : Callback<RSSObject> {

    var callRSSObject: Call<RSSObject>? = null
    var webService: WebService? = null

    init {
        val retrofit = Retrofit.Builder()
                .baseUrl(Links.RETROFIT_RSS_ENDPOINT_API)
                .addConverterFactory(GsonConverterFactory.create())
                .build()

        webService = retrofit.create(WebService::class.java)
    }

    fun start() {
        callRSSObject?.cancel()

        callRSSObject = webService?.listNews(link)
        callRSSObject?.enqueue(this)
    }

    fun stop() {
        callRSSObject?.cancel()
    }

    override fun onResponse(call: Call<RSSObject>, response: Response<RSSObject>) {
        callRSSObject = null
        if (response.isSuccessful) {
            val rssObject = response.body()
            if (rssObject != null && rssObject.items != null) {
                var newses: MutableList<News> = mutableListOf()
                rssObject.items.forEach {
                    newses.add(MapperToNews.fromItem(it))
                }
                callback.onSuccess(newses)
                callback.updateDataBase(newses)
            }
        }
    }

    override fun onFailure(call: Call<RSSObject>?, t: Throwable?) {
        callRSSObject = null
        callback.onFailure()
        t?.printStackTrace()
    }

}