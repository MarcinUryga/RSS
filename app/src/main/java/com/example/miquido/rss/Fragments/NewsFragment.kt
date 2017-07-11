package com.example.miquido.rss.Fragments

import android.os.AsyncTask
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.util.Log
import android.view.*
import com.example.miquido.rss.Adapter.FeedAdapter
import com.example.miquido.rss.Common.HTTPDataHandler
import com.example.miquido.rss.Common.Links
import com.example.miquido.rss.Model.RSSObject
import com.example.miquido.rss.R
import com.example.miquido.rss.WebServicesAdapterPattern.GetNewsFromWebServiceAdapter
import com.google.gson.Gson
import kotlinx.android.synthetic.main.news_fragment.*
import android.support.v7.app.AppCompatActivity



/**
 * Created by marci on 2017-07-11.
 */
class NewsFragment(private val link: String): Fragment() {

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View {
        var view: View = inflater!!.inflate(R.layout.news_fragment, container, false)
        (activity as AppCompatActivity).setSupportActionBar(toolbarNews)
        return view
    }

    override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
        val linearLayoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
        toolbarNews.title = "NEWS"

        recyclerView.layoutManager = linearLayoutManager

        loadRSS()
    }

    private fun loadRSS() {

        var getNewsFromWebServices = GetNewsFromWebServiceAdapter(recyclerView, context)
        when(link){
            Links.TECHNOLOGY_NEWS_LINK -> getNewsFromWebServices.getTechnologyData(null)
            Links.SCIENCE_NEWS_LINK -> getNewsFromWebServices.getScienceNewsData(null)
            Links.EUROPEAN_NEWS_LINK -> getNewsFromWebServices.getEuropeNewsData(null)
        }

    }

    override fun onCreateOptionsMenu(menu: Menu?, inflater: MenuInflater?) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater?.inflate(R.menu.main_menu, menu)

    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if(item.itemId == R.id.menu_refresh)
            loadRSS()
        return true
    }
}