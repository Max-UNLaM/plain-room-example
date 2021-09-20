package ar.edu.unlam.roomshowcase

import androidx.room.Database
import androidx.room.RoomDatabase
import ar.edu.unlam.roomshowcase.item.Item
import ar.edu.unlam.roomshowcase.item.ItemDao

@Database(
    entities = [Item::class],
    version = 2
)
abstract class AppDatabase : RoomDatabase() {
    abstract fun itemDao(): ItemDao
}