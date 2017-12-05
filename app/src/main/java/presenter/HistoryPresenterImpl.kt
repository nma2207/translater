package presenter

import android.content.Context
import com.example.translater.HistoryView
import model.Model
import model.history.History
import model.ModelImpl
import kotlin.concurrent.thread

/**
 * Created by Марат on 2017-11-27.
 */
class HistoryPresenterImpl:HistoryPresenter{
    var view : HistoryView?=null
    var model: Model?=null
    var context:Context?=null


    override fun getAllHistory() {
        var histList=listOf<History>()
        val thread = Thread({
            histList= model!!.getAllHistory()
        })
        thread.start()
        thread.join()
        setHistory(histList)
    }

    override fun setHistory(list: List<History>) {
        view!!.setHistory(list)
    }

    override fun deleteAllHistory() {
        val thread = Thread({
            model!!.deleteAllHistory()
        })
        thread.start()
        thread.join()
    }
    override fun attachView(v: HistoryView, context: Context) {
        view=v
        model=ModelImpl.getInstance(context)
        this.context=context
    }

    override fun dettachView() {
       view=null
    }
}