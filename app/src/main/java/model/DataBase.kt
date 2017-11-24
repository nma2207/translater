package model

import android.arch.persistence.room.Database
import android.arch.persistence.room.RoomDatabase
import model.history.History
import model.history.HistoryDao
import model.favorites.Favorites
import model.favorites.FavoritesDao

/**
 * Created by Марат on 2017-10-29.
 */
@Database(entities = arrayOf(History::class, Favorites::class), version = 1, exportSchema = false)
abstract class DataBase: RoomDatabase(){
    abstract fun getHistoryDao(): HistoryDao
    abstract fun getFavoritesDao(): FavoritesDao
}
