package ar.edu.unlam.roomshowcase

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.room.Room
import ar.edu.unlam.roomshowcase.robot.Robot
import ar.edu.unlam.roomshowcase.robot.RobotDao

class MainActivity : AppCompatActivity() {

    private lateinit var database: AppDatabase
    private lateinit var robotDao: RobotDao

    companion object {
        private fun buildDatabase(context: Context): AppDatabase {
            return Room.databaseBuilder(
                context,
                AppDatabase::class.java,
                "room-showroom-db"
            ).fallbackToDestructiveMigration().allowMainThreadQueries().build()
        }
    }

    /**
     * Manual dependency injection
     */
    private fun injectDependencies() {
        this.database = buildDatabase(this.applicationContext)
        this.robotDao = this.database.itemDao()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        injectDependencies()
        setContentView(R.layout.activity_main)
    }
}