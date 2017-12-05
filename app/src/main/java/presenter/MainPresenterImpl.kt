package presenter

/**
 * Created by Марат on 2017-10-22.
 */

//import javax.inject.Inject
import android.content.Context
import com.example.translater.MainView
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers
import model.history.History
import model.Model
import model.ModelImpl

import android.os.AsyncTask.execute
import com.unikre.yandex.YandexTranslator
import com.unikre.yandex.params.Language




class MainPresenterImpl:MainPresenter  {
    //    val yaApiService by lazy {
//        YandexTranslateApiService.create()
//    }
    var disposable: Disposable? = null
    var view : MainView?=null
    var model:Model?=null
    var context:Context?=null
    val key="trnsl.1.1.20171016T111419Z.fc55cd5c198738d8.3c01307e69f137c8b02570ba469a2dd01d6740b3"
    val translator=YandexTranslator(key)

    override fun attachView(v:MainView, context: Context){
        view = v
        model = ModelImpl.getInstance(context)
        this.context=context

    }





    override fun sendToTranslate(text: String, langFrom: String, langTo:String) {

        val key = "trnsl.1.1.20171016T111419Z.fc55cd5c198738d8.3c01307e69f137c8b02570ba469a2dd01d6740b3"
        val format = "plain"

        val thread= Thread(Runnable {

            try {
                val from=Language.byCode(langFrom)
                val to = Language.byCode(langTo)
                val res = translator.translate(text, from, to)
                setTranslated(res)
            } catch (e: Exception) {
                setTranslated(e.toString())
            }
        })
        thread.start()


        //yaApiService.getTranslate(key, lang, format, text)
//                .subscribeOn(Schedulers.io())
//                .observeOn(AndroidSchedulers.mainThread())
//                .subscribeOn(
//                        { result -> txt_search_result.text = "${result.query.searchinfo.totalhits} result found" },
//                        { error -> Toast.makeText(this, error.message, Toast.LENGTH_SHORT).show() }
//                )

    }

    override fun getLangs(){
        val thread= Thread(Runnable {

            try {
                val res = translator.getSupportedLanguages()
                setLangs(res)

            } catch (e: Exception) {
                setLangs(listOf(Language.RUSSIAN, Language.ENGLISH))
            }
        })
        thread.start()
        //setLangs(listOf(Language.RUSSIAN, Language.ENGLISH))
    }

    override fun setLangs(list: List<Language>) {
        view!!.setLangs(list)
    }

    override fun setTranslated(word:String) {

        view!!.setTranslated(word);

    }

    override fun dettachView() {
        view=null;

    }

//    private fun beginSearch(key:String, text:String, lang:String, format:String):String {
//        val translatorBackgroundTask = TranslatorBackgroundTask(context!!)
//        val translationResult = translatorBackgroundTask.execute(text, lang) // Returns the translated text as a String
//        //Log.d("Translation Result", translationResult)
//        return "otvet"
//
//    }

}