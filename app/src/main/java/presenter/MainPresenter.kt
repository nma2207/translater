package presenter

import android.content.Context
import com.example.translater.MainView
import com.unikre.yandex.params.Language
import model.history.History

/**
 * Created by Марат on 2017-11-12.
 */
interface MainPresenter {
    fun sendToTranslate(text:String, langFrom:String, langTo:String)
    fun setTranslated(word:String)
    fun getLangs()
    fun setLangs(list:List<String>)
//    fun sendToGetLangList()
//    fun getHistory():List<History>
    fun attachView(v:MainView, context: Context)
    fun dettachView()
    fun addFavorites(text:String, langFrom:String, langTo:String)
}
