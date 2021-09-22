package ar.edu.unlam.roomshowcase.robot

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query

@Dao
interface RobotDao {

    @Query("SELECT * FROM items")
    fun getAll(): List<Robot>

    @Query("SELECT * FROM items WHERE id = :id")
    fun getById(id: Long): List<Robot>

    @Delete
    fun delete(robot: Robot)

    @Insert
    fun insert(vararg robot: Robot)
}