package ar.edu.unlam.roomshowcase.item

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query

@Dao
interface ItemDao {

    @Query("SELECT * FROM items")
    fun getAll(): List<Item>

    @Query("SELECT * FROM items WHERE id = :id")
    fun getById(id: Long): List<Item>

    @Delete
    fun delete(item: Item)

    @Insert
    fun insert(vararg item: Item)
}