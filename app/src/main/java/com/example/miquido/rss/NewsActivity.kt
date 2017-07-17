package com.example.miquido.rss

import android.app.Activity
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.example.miquido.rss.Common.Links
import com.example.miquido.rss.Fragments.NewsFragment

import kotlinx.android.synthetic.main.activity_news.*

class NewsActivity : AppCompatActivity() {

    private val fragmentManager = supportFragmentManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_news)

        switchNews(Links.EUROPEAN_NEWS_LINK)

        //bottom_navigation.menu.add()

        bottom_navigation.setOnNavigationItemSelectedListener {
            when(it.itemId){
                R.id.action_europe -> switchNews(Links.EUROPEAN_NEWS_LINK)
                R.id.action_science -> switchNews(Links.SCIENCE_NEWS_LINK)
                R.id.action_technology -> switchNews(Links.TECHNOLOGY_NEWS_LINK)
                else -> {
                    switchNews(Links.EUROPEAN_NEWS_LINK)
                }
            }
        }
    }

    fun switchNews(link: String): Boolean {
        var fragmentTransaction: android.support.v4.app.FragmentTransaction? = fragmentManager.beginTransaction()
        var currentFragment = NewsFragment(link)

        fragmentTransaction?.replace(R.id.fragment_container, currentFragment)

        //fragmentTransaction?.addToBackStack(null)

        fragmentTransaction?.commit()

        return true
    }

    override fun onBackPressed() {
        if(getFragmentManager().backStackEntryCount == 0)
            super.onBackPressed()
        else
            getFragmentManager().popBackStack()
    }


}