package com.example.translater

import model.history.History

/**
 * Created by Марат on 2017-11-27.
 */
interface HistoryView {
    fun getHistory()
    fun setHistory(list:List<History>)
    fun deleteAllHistory()

}