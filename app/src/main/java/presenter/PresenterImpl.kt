package presenter

/**
 * Created by Марат on 2017-10-22.
 */

//import javax.inject.Inject
import android.content.Context
import com.example.translater.View
import model.history.History
import model.Model
import model.ModelIml
class PresenterImpl:Presenter  {
    //    val yaApiService by lazy {
//        YandexTranslateApiService.create()
//    }
    var view : View?=null
    var model:Model?=null
    override fun attachView(v:View, context: Context){
        view = v
        model = ModelIml(context)

    }
    override fun dettachView(){
        view = null
    }

    override fun sendToGetLangList() {
    }



    override fun sendToTranslate(text: String, lang: String) {
        //TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
        val key = "trnsl.1.1.20171016T111419Z.fc55cd5c198738d8.3c01307e69f137c8b02570ba469a2dd01d6740b3"
        val format = "plain"

        model?.addHistory(text, lang, "")
        println("Add $text")
        //yaApiService.getTranslate(key, lang, format, text)
//                .subscribeOn(Schedulers.io())
//                .observeOn(AndroidSchedulers.mainThread())
//                .subscribeOn(
//                        { result -> txt_search_result.text = "${result.query.searchinfo.totalhits} result found" },
//                        { error -> Toast.makeText(this, error.message, Toast.LENGTH_SHORT).show() }
//                )

    }

    override fun getHistory(): List<History> {
        return model!!.getAllHistory()
    }


}