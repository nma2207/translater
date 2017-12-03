package presenter

import android.content.Context
import com.example.translater.MainView
import model.history.History

/**
 * Created by Марат on 2017-11-12.
 */
interface MainPresenter {
    fun sendToTranslate(text:String, lang:String)
    fun setTranslated(word:String)
    fun getLangs()
    fun setLangs(list:List<String>)
//    fun sendToGetLangList()
//    fun getHistory():List<History>
    fun attachView(v:MainView, context: Context)
    fun dettachView()
}
