package model.history

/**
 * Created by Марат on 2017-11-24.
 */
import android.arch.persistence.room.*
import io.reactivex.Flowable

@Entity(tableName = "history")
class History(
        @PrimaryKey(autoGenerate = true)
        val id:Int,
        val text: String = "",
        val langFrom: String  =  "",
        val langTo: String  =  "",
        val translated:String = ""
)

@Dao interface HistoryDao{
    @Insert
    fun insert(h: History)
    @Delete
    fun delete(h:History)
    @Query("SELECT * FROM history")
    fun getAllHistory() : List<History>
    @Delete
    fun deleteAll(list: List<History>)
    @Query("DELETE FROM history")
    fun clearTable()

}