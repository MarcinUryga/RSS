package com.example.miquido.rss.Fragments

import android.content.Context
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.miquido.rss.Common.Links
import com.example.miquido.rss.R
import com.example.miquido.rss.interfaces.OverviewFragmentActivityListener
import kotlinx.android.synthetic.main.overview_fragment.*

/**
 * Created by miquido on 11.07.2017.
 */
class OverviewFragment: Fragment() {
    var listener: OverviewFragmentActivityListener ?= null

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater?.inflate(R.layout.overview_fragment, container, false)

        return view
    }

    override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {

        newsBtn.setOnClickListener {
            onItemSelected("news")
        }

        technologyNewsBtn.setOnClickListener{
            onItemSelected(Links.TECHNOLOGY_NEWS_LINK)
        }
        scienceNewsBtn.setOnClickListener {
            onItemSelected(Links.SCIENCE_NEWS_LINK)
        }
        europeanNewsBtn.setOnClickListener {
            onItemSelected(Links.EUROPEAN_NEWS_LINK)
        }
    }

    override fun onAttach(context: Context?) {
        super.onAttach(context)
        if(context is OverviewFragmentActivityListener)
            listener = context
        else
            throw ClassCastException("context: " + context.toString()
                    + " has to implement interface: " + "OverviewFragmentActivityListener")
    }

    fun onItemSelected(link: String){
        listener?.onClickItem(link)
    }

}

