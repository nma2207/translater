package model.favorites

/**
 * Created by Марат on 2017-11-24.
 */
import android.arch.persistence.room.*
import io.reactivex.Flowable

/**
 * Created by Марат on 2017-10-22.
 */
@Entity(tableName = "favorites")
class Favorites(
        @PrimaryKey(autoGenerate = true)
        val id:Int,
        val text: String = "",
        val lang: String  =  "",
        val translated:String = ""
)


@Dao interface FavoritesDao{
    @Insert
    fun insert(f:Favorites)
    @Delete
    fun delete(f: Favorites)
    @Query("SELECT * FROM favorites")
    fun getAllHistory() : List<Favorites>
}