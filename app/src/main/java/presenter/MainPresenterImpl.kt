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

        var res=text
        val thread= Thread(Runnable {

            try {
                val from=Language.byCode(langFrom)
                val to = Language.byCode(langTo)
                res = translator.translate(text, from, to)
                model!!.addHistory(text,langFrom,langTo,res)
                setTranslated(res)
            } catch (e: Exception) {
                setTranslated(e.toString())
            }
        })
        thread.start()
        thread.join()
        model!!.addHistory(text,langFrom,langTo,res)


    }

    override fun getLangs(){
        //val langs = listOf<String>(af, am, ar, az, ba, be, bg, bn, bs, ca, ceb, cs, cy, da, de, el, en, eo, es, et, eu, fa, fi, fr, ga, gd, gl, gu, he, hi, hr, ht, hu, hy, id, is, it, ja, jv, ka, kk, km, kn, ko, ky, la, lb, lo, lt, lv, mg, mhr, mi, mk, ml, mn, mr, mrj, ms, mt, my, ne, nl, no, pa, pap, pl, pt, ro, ru, si, sk, sl, sq, sr, su, sv, sw, ta, te, tg, th, tl, tr, tt, udm, uk, ur, uz, vi, xh, yi, zh])
        var res = listOf<String>()
        val thread= Thread(Runnable {
            try {

                res = translator.getSupportedLanguages().map{it.toString()}


            } catch (e: Exception) {
                res=listOf("ru", "en")
            }
        })
        thread.start()

        thread.join()
        setLangs(res)

    }

    override fun setLangs(list: List<String>) {

        view!!.setLangs(list)
    }

    override fun setTranslated(word:String) {

        view!!.setTranslated(word);

    }

    override fun dettachView() {
        view=null;

    }

    override fun addFavorites(text: String, langFrom: String, langTo: String) {
        var res=text
        val thread= Thread(Runnable {

            try {
                val from=Language.byCode(langFrom)
                val to = Language.byCode(langTo)
                res = translator.translate(text, from, to)
                model!!.addHistory(text,langFrom,langTo,res)
                setTranslated(res)
            } catch (e: Exception) {
                setTranslated(e.toString())
            }
        })
        model!!.addFavorites(text,langFrom,langTo,res)
        thread.start()
        thread.join()
    }



}