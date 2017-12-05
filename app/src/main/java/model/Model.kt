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
import model.favorites.Favorites

interface Model {
    //History
    fun addHistory(text:String, langFrom:String,langTo:String, translated:String)
    fun getAllHistory():List<History>
    fun deleteAllHistory()
    //Favorites
    fun addFavorites(text:String, langFrom:String,langTo:String, translated:String)
    fun getAllFavorites():List<Favorites>
    fun deleteAllFavorites()

}

class ModelImpl:Model{
    ////////////////////////////////////////////////////////////////////////////////////////////////
    override fun addHistory(text: String, langFrom: String,langTo:String, translated: String) {
        val hist = History(0,text,langFrom,langTo,translated)
        Single.fromCallable {
            dataBase?.getHistoryDao()?.insert(hist)
        }.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread()).subscribe()
    }
////////////////////////////////////////////////////////////////////////////////////////////////

    override fun getAllHistory(): List<History> {
        return dataBase?.getHistoryDao()?.getAllHistory()!!

    }
    ////////////////////////////////////////////////////////////////////////////////////////////////
    override fun deleteAllHistory() {
        val hist = getAllHistory()
        dataBase!!.getHistoryDao()!!.deleteAll(hist)

    }
    ////////////////////////////////////////////////////////////////////////////////////////////////
    override fun addFavorites(text: String, langFrom: String, langTo: String, translated: String) {
        val fav = Favorites(0,text,langFrom,langTo,translated)
        Single.fromCallable {
            dataBase?.getFavoritesDao()?.insert(fav)
        }.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread()).subscribe()
    }
    ////////////////////////////////////////////////////////////////////////////////////////////////
    override fun getAllFavorites(): List<Favorites> {
        return dataBase?.getFavoritesDao()?.getAllFavorites()!!
    }
    ////////////////////////////////////////////////////////////////////////////////////////////////
    override fun deleteAllFavorites() {
        val favorites = getAllFavorites()
        dataBase!!.getFavoritesDao()!!.deleteAll(favorites)

    }
    ////////////////////////////////////////////////////////////////////////////////////////////////
    private constructor(context: Context){
        if (dataBase==null)
            dataBase=Room.databaseBuilder(context, DataBase::class.java, "my_db").build()
    }
    ////////////////////////////////////////////////////////////////////////////////////////////////
    companion object {
        @Volatile private var instance:ModelImpl?=null
        var dataBase:DataBase?=null
        ////////////////////////////////////////////////////////////////////////////////////////////////
        fun getInstance(context:Context):ModelImpl?{
            if(instance==null)
                instance=ModelImpl(context)
            return instance
        }
////////////////////////////////////////////////////////////////////////////////////////////////

    }

}
