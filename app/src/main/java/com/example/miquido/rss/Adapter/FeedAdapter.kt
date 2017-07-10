package com.example.miquido.rss.Adapter

import android.content.Context
import android.content.Intent
import android.net.Uri
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.example.miquido.rss.Model.RSSObject
import com.example.miquido.rss.R
import com.example.miquido.rss.interfaces.ItemClickListener

/**
 * Created by miquido on 10.07.2017.
 */

class FeedViewHolder(itemView: View): RecyclerView.ViewHolder(itemView), View.OnClickListener, View.OnLongClickListener {

    var txtTitle: TextView
    var txtPubdate: TextView
    var txtContent: TextView

    private var itemClickListener : ItemClickListener?=null

    init{
        txtTitle = itemView.findViewById<TextView>(R.id.txtTitle)
        txtPubdate = itemView.findViewById<TextView>(R.id.txtPubdate)
        txtContent = itemView.findViewById<TextView>(R.id.txtContent)

        itemView.setOnClickListener(this)
        itemView.setOnLongClickListener(this)
    }

    fun setItemClickListener(itemClickListener: ItemClickListener){
        this.itemClickListener = itemClickListener
    }

    override fun onClick(v: View?) {
        itemClickListener?.let { it.onClick(v,adapterPosition, false) }
    }

    override fun onLongClick(v: View?): Boolean {
        itemClickListener?.let{ it.onClick(v,adapterPosition, true) }

        return true
    }
}

class FeedAdapter(private val rssObject: RSSObject, private val mContext: Context):RecyclerView.Adapter<FeedViewHolder>(){

    private val inflater:LayoutInflater

    init{
        inflater = LayoutInflater.from(mContext)
    }

    override fun getItemCount(): Int {
        return rssObject.items.size
    }

    override fun onBindViewHolder(holder: FeedViewHolder, position: Int) {
        holder.txtTitle.text = rssObject.items[position].title
        holder.txtContent.text = rssObject.items[position].content
        holder.txtPubdate.text = rssObject.items[position].pubDate

        holder.setItemClickListener(ItemClickListener { view, position, isLongClick ->

            if(!isLongClick){
                val browserIntent = Intent(Intent.ACTION_VIEW, Uri.parse(rssObject.items[position].link))
                mContext.startActivity(browserIntent)
            }

        })
    }

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): FeedViewHolder {
        val view = inflater.inflate(R.layout.item, parent, false)

        return FeedViewHolder(view)
    }

}