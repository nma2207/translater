package presenter

import android.content.Context
import com.example.translater.FavoritesView
import model.Model
import model.favorites.Favorites

/**
 * Created by Марат on 2017-11-27.
 */
class FavirotesPresenterImpl:FavoritePresenter {
    var view : FavoritesView?=null
    var model: Model?=null
    var context:Context?=null
    override fun getAllFavorites() {
        val favList = model!!.getAllFavorites()
        setFavorites(favList)
    }

    override fun setFavorites(list: List<Favorites>) {
        view!!.setFavorites(list)
    }

    override fun deleteAllFavorite() {
        model!!.deleteAllFavorites()
    }
    override fun attachView(v: FavoritesView, context: Context) {
        view = v
        this.context=context
    }

    override fun dettachView() {
        view=null
    }
}