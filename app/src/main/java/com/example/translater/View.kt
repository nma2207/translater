package com.example.translater

import model.history.History

/**
 * Created by Марат on 2017-11-12.
 */
interface View {

    fun sendToGetTranslate(text:String, lang:String)
    fun getHistory():List<History>
}