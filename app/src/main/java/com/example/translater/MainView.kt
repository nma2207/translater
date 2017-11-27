package com.example.translater

import model.history.History

/**
 * Created by Марат on 2017-11-12.
 */
interface MainView {

    fun sendToGetTranslate(text:String, lang:String)
    fun setTranslated(s:String)
}