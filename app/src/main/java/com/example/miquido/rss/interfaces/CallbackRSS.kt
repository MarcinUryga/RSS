package com.example.miquido.rss.interfaces

import com.example.miquido.rss.Model.RSSObject

/**
 * Created by MiQUiDO on 12.07.2017.
 * <p>
 * Copyright 2017 MiQUiDO <http://www.miquido.com/>. All rights reserved.
 */
interface CallbackRSS {
    fun onSuccess(rss: RSSObject)
    fun updateDataBase(let: RSSObject) {}
}