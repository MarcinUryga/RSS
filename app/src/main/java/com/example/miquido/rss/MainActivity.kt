package com.example.miquido.rss

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.Menu
import android.view.MenuInflater
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
/*
        val linearLayoutManager = LinearLayoutManager(baseContext, LinearLayoutManager.VERTICAL, false)
        recyclerView.layoutManager = linearLayoutManager

        loadRSS()
*/
    }


    private fun setOverviewFragment() {
        var fragmentTransaction: android.support.v4.app.FragmentTransaction? = fragmentManager.beginTransaction()
        var currentFragment = OverviewFragment()

        fragmentTransaction?.replace(R.id.fragment_container, currentFragment)
        fragmentTransaction?.commit()

    }

    override fun onClickItem(link: String) {
        var fragmentTransaction: android.support.v4.app.FragmentTransaction? = fragmentManager.beginTransaction()
        var currentFragment = NewsFragment(link)

        fragmentTransaction?.replace(R.id.fragment_container, currentFragment)

        fragmentTransaction?.addToBackStack(null)

        fragmentTransaction?.commit()
    }

   /*



*/
}
