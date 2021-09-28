package ar.edu.unlam.roomshowcase

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.migration.Migration
import androidx.sqlite.db.SupportSQLiteDatabase
import ar.edu.unlam.roomshowcase.robot.Robot
import ar.edu.unlam.roomshowcase.robot.RobotDao

val MIGRATION_1_2  = object : Migration(1, 2) {
    override fun migrate(database: SupportSQLiteDatabase) {
        database.execSQL(
            """
            INSERT INTO robots (name)
            VALUES("2b"),("rd2d");
            """
        )
    }
}


@Database(
    entities = [Robot::class],
    version = 3
)
abstract class AppDatabase : RoomDatabase() {
    abstract fun robotDao(): RobotDao
}