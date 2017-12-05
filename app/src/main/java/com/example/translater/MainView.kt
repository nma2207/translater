package com.example.translater

import com.unikre.yandex.params.Language
import model.history.History

/**
 * Created by Марат on 2017-11-12.
 */
interface MainView {

    fun sendToGetTranslate(text:String, langFrom:String, langTo:String)
    fun setTranslated(s:String)
    fun getLangs()
    fun setLangs(list:List<Language>)
}