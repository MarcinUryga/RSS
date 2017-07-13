package com.example.miquido.rss

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.example.miquido.rss.Fragments.NewsFragment
import com.example.miquido.rss.Fragments.OverviewFragment
import com.example.miquido.rss.interfaces.OverviewFragmentActivityListener
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), OverviewFragmentActivityListener {


    private val fragmentManager = supportFragmentManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        mainTolbar.title = "Main Menu"

        setSupportActionBar(mainTolbar)

        setOverviewFragment()
    }

    private fun setOverviewFragment() {
        var fragmentTransaction: android.support.v4.app.FragmentTransaction? = fragmentManager.beginTransaction()
        var currentFragment = OverviewFragment()

        fragmentTransaction?.replace(R.id.fragment_container, currentFragment)
        fragmentTransaction?.commit()

    }

    override fun onClickItem(link: String) {

        if(link.equals("news")){
            val activityIntent = Intent(baseContext, NewsActivity::class.java)
            baseContext.startActivity(activityIntent)
        }

        var fragmentTransaction: android.support.v4.app.FragmentTransaction? = fragmentManager.beginTransaction()
        var currentFragment = NewsFragment(link)

        fragmentTransaction?.replace(R.id.fragment_container, currentFragment)

        fragmentTransaction?.addToBackStack(null)

        fragmentTransaction?.commit()
    }

}
