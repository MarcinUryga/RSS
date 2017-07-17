package com.example.miquido.rss.Adapter

import android.content.Context
import android.content.Intent
import android.net.Uri
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import com.example.miquido.rss.Model.Item
import com.example.miquido.rss.Model.RSSObject
import com.example.miquido.rss.R
import com.example.miquido.rss.database.pojo.News
import kotlinx.android.synthetic.main.item.view.*
import retrofit2.Call

/**
* Created by MiQUiDO on 12.07.2017.
* <p>
* Copyright 2017 MiQUiDO <http://www.miquido.com/>. All rights reserved.
*/

class FeedViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {

    var txtTitle: TextView
    var txtPubdate: TextView
    var txtContent: TextView

    init{
        txtTitle = itemView.txtTitle
        txtPubdate = itemView.txtPubdate
        txtContent = itemView.txtContent
    }

    fun bindFun(news: News){
        txtTitle.text = news.newsTitle
        txtContent.text = news.newsContent
        txtPubdate.text = news.newsDate
    }

}

class FeedAdapter(private val newses: List<News>,
                  private val context: Context
    ):RecyclerView.Adapter<FeedViewHolder>(){

    override fun getItemCount(): Int {
        return newses.size
    }

    override fun onBindViewHolder(holder: FeedViewHolder, position: Int) {

        holder.bindFun(newses[position])

        holder.itemView.setOnClickListener {
            val browserIntent = Intent(Intent.ACTION_VIEW, Uri.parse("http://damianchodorek.com/kurs-android-baza-danych-realm-20/"))
            context.startActivity(browserIntent)
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FeedViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item, parent, false)

        return FeedViewHolder(view)
    }

}