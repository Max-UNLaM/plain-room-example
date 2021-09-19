package ar.edu.unlam.roomshowcase.item

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Query

@Dao
interface ItemDao {

    @Query("SELECT * FROM items")
    fun getAll(): List<Item>

    @Delete
    fun delete(user: Item)
}