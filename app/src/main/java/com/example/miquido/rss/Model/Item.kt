package com.example.miquido.rss.Model

/**
 * Created by miquido on 10.07.2017.
 */
data class Item(val title: String, val pubDate: String, val link: String, val guid: String,
                val author: String, val thumbnail: String, val description: String,
                val content: String, val enclosure: Object, val categories: List<String>) {
}