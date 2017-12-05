package presenter

import android.content.Context
import com.example.translater.FavoritesView
import model.Model
import model.favorites.Favorites
import model.ModelImpl
/**
 * Created by Марат on 2017-11-27.
 */
class FavirotesPresenterImpl:FavoritePresenter {
    var view : FavoritesView?=null
    var model: Model?=null
    var context:Context?=null
    override fun getAllFavorites() {
        var favList = listOf<Favorites>()
        val thread = Thread({
            favList = model!!.getAllFavorites()
        })
        thread.start()
        thread.join()
        setFavorites(favList)
    }

    override fun setFavorites(list: List<Favorites>) {
        view!!.setFavorites(list)
    }

    override fun deleteAllFavorite() {
        val thread = Thread({
            model!!.deleteAllFavorites()
        })
        thread.start()
        thread.join()
    }
    override fun attachView(v: FavoritesView, context: Context) {
        view = v
        model = ModelImpl.getInstance(context)
        this.context=context
    }

    override fun dettachView() {
        view=null
    }
}