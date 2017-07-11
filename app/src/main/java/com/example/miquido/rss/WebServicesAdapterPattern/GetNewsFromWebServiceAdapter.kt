package com.example.miquido.rss.WebServicesAdapterPattern

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.util.Log
import com.example.miquido.rss.Adapter.FeedAdapter
import com.example.miquido.rss.Common.Links
import com.example.miquido.rss.Model.RSSObject
import retrofit.Callback
import retrofit.RestAdapter
import retrofit.RetrofitError
import retrofit.client.Response

/**
 * Created by marci on 2017-07-11.
 */
class GetNewsFromWebServiceAdapter(private val recyclerView: RecyclerView, private val context: Context) : WebService {

    val retrofit = RestAdapter.Builder().setEndpoint(Links.RETROFIT_RSS_ENDPOINT_API)
            .setLogLevel(RestAdapter.LogLevel.FULL).build()

    val webService = retrofit.create(WebService::class.java)

    override fun getScienceNewsData(pResponse: Callback<RSSObject>?) {
        webService.getScienceNewsData(object: Callback<RSSObject> {
            override fun success(rssObject: RSSObject, response: Response?) {

                val adapter = FeedAdapter(rssObject, context)
                recyclerView.adapter = adapter
                adapter.notifyDataSetChanged()

            }

            override fun failure(error: RetrofitError?) {
                Log.d("ERROR", "Cannot get data from server")
            }

        })
    }

    override fun getEuropeNewsData(pResponse: Callback<RSSObject>?) {
        webService.getEuropeNewsData(object: Callback<RSSObject> {
            override fun success(rssObject: RSSObject, response: Response?) {

                val adapter = FeedAdapter(rssObject, context)
                recyclerView.adapter = adapter
                adapter.notifyDataSetChanged()

            }

            override fun failure(error: RetrofitError?) {
                Log.d("ERROR", "Cannot get data from server")
            }

        })
    }

    override fun getTechnologyData(pResponse: Callback<RSSObject>?) {
        webService.getTechnologyData(object: Callback<RSSObject> {
            override fun success(rssObject: RSSObject, response: Response?) {

                val adapter = FeedAdapter(rssObject, context)
                recyclerView.adapter = adapter
                adapter.notifyDataSetChanged()

            }

            override fun failure(error: RetrofitError?) {
                Log.d("ERROR", "Cannot get data from server")
            }

        })
    }

}