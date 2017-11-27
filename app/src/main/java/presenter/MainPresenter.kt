package presenter

import android.content.Context
import com.example.translater.MainView
import model.history.History

/**
 * Created by Марат on 2017-11-12.
 */
interface MainPresenter {
    fun sendToTranslate(text:String, lang:String)
    fun getTranslated():String
    fun getLangs():List<String>
//    fun sendToGetLangList()
//    fun getHistory():List<History>
    fun attachView(v:MainView, context: Context)
    fun dettachView()
}
