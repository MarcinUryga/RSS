package com.example.miquido.rss

import android.support.v7.app.AppCompatActivity
import android.os.Bundle

import com.example.miquido.rss.R
import kotlinx.android.synthetic.main.activity_main2.*

class Main2Activity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)

        bottom_navigation.setOnNavigationItemSelectedListener {
            when(it.itemId){

            }
        }


    }
}
