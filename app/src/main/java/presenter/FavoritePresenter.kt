package presenter

import android.content.Context
import com.example.translater.FavoritesView
import model.favorites.Favorites

/**
 * Created by Марат on 2017-11-27.
 */
interface FavoritePresenter {
    fun getAllFavorites()
    fun setFavorites(list: List<Favorites>)
    fun deleteAllFavorite()
    fun attachView(v:FavoritesView, context: Context)
    fun dettachView()
}