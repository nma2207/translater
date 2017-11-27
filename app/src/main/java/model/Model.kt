package model

import model.history.History
import android.arch.persistence.room.Room
/**
 * Created by Марат on 2017-11-18.
 */
import android.content.Context
import io.reactivex.Scheduler
import io.reactivex.Single
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

interface Model {
    fun addHistory(text:String, lang:String, translated:String)
    fun getAllHistory():List<History>
}

class ModelImpl:Model{






    override fun addHistory(text: String, lang: String, translated: String) {
        val hist = History(0,text,lang,translated)
        Single.fromCallable {
            dataBase?.getHistoryDao()?.insert(hist)
        }.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread()).subscribe()
        //TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }


    override fun getAllHistory(): List<History> {
        return listOf(History(0,"land","ad","sd"))

    }
    private constructor(context: Context){
        if (dataBase==null)
            dataBase=Room.databaseBuilder(context, DataBase::class.java, "my_db").build()
    }
    companion object {
        @Volatile private var instance:ModelImpl?=null
        var dataBase:DataBase?=null
        fun getInstance(context:Context):ModelImpl?{
            if(instance==null)
                instance=ModelImpl(context)
            return instance
        }


    }

}
