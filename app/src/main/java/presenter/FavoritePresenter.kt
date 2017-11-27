package presenter

import android.content.Context
import com.example.translater.FavoritesView
import model.favorites.Favorites

/**
 * Created by Марат on 2017-11-27.
 */
interface FavoritePresenter {
    fun getAllFavorites():List<Favorites>
    fun deleteFavorite(f:Favorites)
    fun attachView(v:FavoritesView, context: Context)
    fun dettachView()
}