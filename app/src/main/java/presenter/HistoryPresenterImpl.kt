package presenter

import android.content.Context
import com.example.translater.HistoryView
import model.Model
import model.history.History

/**
 * Created by Марат on 2017-11-27.
 */
class HistoryPresenterImpl:HistoryPresenter{
    var view : HistoryView?=null
    var model: Model?=null
    var context:Context?=null


    override fun getAllHistory() {
       val histList = model!!.getAllHistory()
        setHistory(histList)
    }

    override fun setHistory(list: List<History>) {
        view!!.setHistory(list)
    }

    override fun deleteAllHistory() {
        model!!.deleteAllHistory()
    }
    override fun attachView(v: HistoryView, context: Context) {
        view=v
        this.context=context
    }

    override fun dettachView() {
       view=null
    }
}