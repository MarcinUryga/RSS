package com.example.miquido.rss

import android.os.AsyncTask
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import com.example.miquido.rss.Adapter.FeedAdapter
import com.example.miquido.rss.Common.HTTPDataHandler
import com.example.miquido.rss.Model.RSSObject
import com.example.miquido.rss.interfaces.OverviewFragmentActivityListener
import com.example.miquido.rss.interfaces.WebService
import com.google.gson.Gson
import kotlinx.android.synthetic.main.activity_main.*
import retrofit.Callback
import retrofit.RestAdapter
import retrofit.RetrofitError
import retrofit.client.Response

class MainActivity : AppCompatActivity(), OverviewFragmentActivityListener {
    private val RSS_link = "http://rss.nytimes.com/services/xml/rss/nyt/Science.xml"
    private val RSS_to_JSON_API = "https://api.rss2json.com/v1/api.json?rss_url="

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        toolbar.title = "NEWS"
        setSupportActionBar(toolbar)

        val linearLayoutManager = LinearLayoutManager(baseContext, LinearLayoutManager.VERTICAL, false)
        recyclerView.layoutManager = linearLayoutManager

        loadRSS()

    }

    private fun loadRSS() {

        val retrofit = RestAdapter.Builder().setEndpoint("https://api.rss2json.com/v1/api.json?rss_url=http://rss.nytimes.com")
                .setLogLevel(RestAdapter.LogLevel.FULL).build()

        val webService = retrofit.create(WebService::class.java)

        //webService.getScienceData(object: Callback<RSSObject>{
        //webService.getEuropeNewsData(object: Callback<RSSObject>{
        webService.getTechnologyData(object: Callback<RSSObject>{
            override fun success(rssObject: RSSObject, response: Response?) {

                val adapter = FeedAdapter(rssObject, baseContext)
                recyclerView.adapter = adapter
                adapter.notifyDataSetChanged()

            }

            override fun failure(error: RetrofitError?) {
                Log.d("ERROR", "Cannot get data from server")
            }

        })
    }

    private fun loadRSSwithAsyncTask(){
        val loadRSSAsync = object: AsyncTask<String, String, String>(){
            //   internal var mProgress = ProgressDialog(this@MainActivity)

            override fun onPreExecute() {
                //     mProgress.setMessage("Wait")
                //     mProgress.show()
            }

            override fun doInBackground(vararg p0: String?): String {
                val result:String
                val http = HTTPDataHandler()

                result = http.GetHTTPDataHandler(p0[0])
                return result
            }

            override fun onPostExecute(result: String?) {
                //   mProgress.dismiss()
                Log.d("RESULTSSS:", result)
                var rssObject:RSSObject
                rssObject = Gson().fromJson<RSSObject>(result, RSSObject::class.java!!)

                val adapter = FeedAdapter(rssObject, baseContext)
                recyclerView.adapter = adapter
                adapter.notifyDataSetChanged()
            }
        }


        var url_get_data = StringBuilder(RSS_to_JSON_API)
        url_get_data.append(RSS_link)

        loadRSSAsync.execute(url_get_data.toString())
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.main_menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if(item.itemId == R.id.menu_refresh)
            loadRSS()
        return true
    }

    override fun onClickItem(link: String) {
        Log.d("OK", link)
    }

}
