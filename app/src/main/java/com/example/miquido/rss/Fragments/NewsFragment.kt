package com.example.miquido.rss.Fragments

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.view.*
import com.example.miquido.rss.Adapter.FeedAdapter
import com.example.miquido.rss.Model.RSSObject
import com.example.miquido.rss.R
import com.example.miquido.rss.WebServicesAdapterPattern.NewsFromWebServiceController
import com.example.miquido.rss.interfaces.CallbackRSS
import kotlinx.android.synthetic.main.news_fragment.*
import retrofit2.Callback


/**
 * Created by marci on 2017-07-11.
 */
class NewsFragment(private val link: String): Fragment(), CallbackRSS {

    val news = NewsFromWebServiceController(link, this)

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View {
        var view: View = inflater!!.inflate(R.layout.news_fragment, container, false)
        (activity as AppCompatActivity).setSupportActionBar(toolbarNews)
        return view
    }

    override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
        val linearLayoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
        toolbarNews.title = "NEWS"

        recyclerView.layoutManager = linearLayoutManager

        news.start()
    }


    override fun onDestroyView() {
        super.onDestroyView()
        news.stop()
    }

    override fun onSuccess(rss: RSSObject) {
        val adapter = FeedAdapter(rss, context)
        recyclerView.adapter = adapter
        adapter?.notifyDataSetChanged()
    }

    override fun onCreateOptionsMenu(menu: Menu?, inflater: MenuInflater?) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater?.inflate(R.menu.main_menu, menu)

    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if(item.itemId == R.id.menu_refresh)
            news.start()
        return true
    }
}