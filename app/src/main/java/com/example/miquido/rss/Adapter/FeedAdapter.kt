package com.example.miquido.rss.Adapter

import android.content.Context
import android.content.Intent
import android.net.Uri
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.example.miquido.rss.Model.Item
import com.example.miquido.rss.Model.RSSObject
import com.example.miquido.rss.R
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

    fun bindFun(item: Item){
        txtTitle.text = item.title
        txtContent.text = item.content
        txtPubdate.text = item.pubDate
    }

}

class FeedAdapter(private val rssObject: RSSObject,
                  private val context: Context
    ):RecyclerView.Adapter<FeedViewHolder>(){

    override fun getItemCount(): Int {
        return rssObject.items.size
    }

    override fun onBindViewHolder(holder: FeedViewHolder, position: Int) {

        holder.bindFun(rssObject.items[position])

        holder.itemView.setOnClickListener {
            val browserIntent = Intent(Intent.ACTION_VIEW, Uri.parse(rssObject.items[position].link))
            context.startActivity(browserIntent)
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FeedViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item, parent, false)

        return FeedViewHolder(view)
    }

}