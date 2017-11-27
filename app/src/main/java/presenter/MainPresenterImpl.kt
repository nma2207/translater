package presenter

/**
 * Created by Марат on 2017-10-22.
 */

//import javax.inject.Inject
import android.content.Context
import com.example.translater.MainView
import model.history.History
import model.Model
import model.ModelImpl
class MainPresenterImpl:MainPresenter  {
    //    val yaApiService by lazy {
//        YandexTranslateApiService.create()
//    }
    var view : MainView?=null
    var model:Model?=null
    override fun attachView(v:MainView, context: Context){
        view = v
        model = ModelImpl.getInstance(context)

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

    override fun getLangs(): List<String> {
        return listOf("lang");
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun getTranslated(): String {
        return "Trans";
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun dettachView() {
        view=null;
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

}