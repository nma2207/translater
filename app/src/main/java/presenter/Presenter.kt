package presenter

import android.content.Context
import com.example.translater.View
import model.history.History

/**
 * Created by Марат on 2017-11-12.
 */
interface Presenter {
    fun sendToTranslate(text:String, lang:String)
    fun sendToGetLangList()
    fun getHistory():List<History>
    fun attachView(v:View, context: Context)
    fun dettachView()
}
