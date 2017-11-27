package presenter

import android.content.Context
import model.history.History
import com.example.translater.HistoryView
/**
 * Created by Марат on 2017-11-27.
 */
interface HistoryPresenter {
    fun getAllHistory()
    fun setHistory(list:List<History>)
    fun deleteHistory(history:History)
    fun attachView(v:HistoryView, context: Context)
    fun dettachView()

}