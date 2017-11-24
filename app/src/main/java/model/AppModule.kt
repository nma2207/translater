package model

import android.content.Context
import android.arch.persistence.room.Room
/**
 * Created by Марат on 2017-10-29.
 */
class AppModule(private  val context:Context){
    fun providesAppContext() = context
    fun providesAppDatabase(context: Context): DataBase =
            Room.databaseBuilder(context, DataBase::class.java, "room-db").allowMainThreadQueries().build()
}