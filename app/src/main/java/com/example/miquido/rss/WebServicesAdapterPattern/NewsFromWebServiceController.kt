package com.example.miquido.rss.WebServicesAdapterPattern

import com.example.miquido.rss.Common.Links
import com.example.miquido.rss.Model.RSSObject
import com.example.miquido.rss.interfaces.CallbackRSS
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.converter.simplexml.SimpleXmlConverterFactory

/**
 * Created by marci on 2017-07-11.
 */
class NewsFromWebServiceController(private val link: String, private val callback: CallbackRSS): Callback<RSSObject> {

    var rssObject: RSSObject ?= null
    var callRSSObject: Call<RSSObject> ?= null
    var webService: WebService ?= null

    init{
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

    fun stop(){
        callRSSObject?.cancel()
    }


    override fun onResponse(call: Call<RSSObject>, response: Response<RSSObject>) {
        callRSSObject = null
        if(response.isSuccessful){
            rssObject = response.body()
            callback.onSuccess(rssObject!!)
        }
    }

    override fun onFailure(call: Call<RSSObject>?, t: Throwable?) {
        callRSSObject = null
        t?.printStackTrace()
    }

}