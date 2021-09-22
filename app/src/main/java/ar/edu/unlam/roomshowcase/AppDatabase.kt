package ar.edu.unlam.roomshowcase

import androidx.room.Database
import androidx.room.RoomDatabase
import ar.edu.unlam.roomshowcase.robot.Robot
import ar.edu.unlam.roomshowcase.robot.RobotDao

@Database(
    entities = [Robot::class],
    version = 2
)
abstract class AppDatabase : RoomDatabase() {
    abstract fun itemDao(): RobotDao
}