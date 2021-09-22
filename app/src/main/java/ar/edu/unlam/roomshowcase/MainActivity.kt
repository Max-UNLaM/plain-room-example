package ar.edu.unlam.roomshowcase

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.room.Room
import ar.edu.unlam.roomshowcase.robot.Robot

class MainActivity : AppCompatActivity() {

    companion object {
        private fun buildDatabase(context: Context): AppDatabase {
            return Room.databaseBuilder(
                context,
                AppDatabase::class.java,
                "room-showroom-db"
            ).fallbackToDestructiveMigration().allowMainThreadQueries().build()
        }

        /**
         * Construirá/entablará la conexión con la base de datos, insertará un elemento en una
         * tabla, imprimirá en consolo los elemntos insertados, borrará el elemento insertado,
         * y volverá a imprimir los elementos que queden en la tabla.
         */
        fun abmDemo(context: Context) {
            val database = buildDatabase(context)
            val itemDao = database.itemDao()
            itemDao.insert(Robot(name = "2B"))
            itemDao.delete(itemDao.getById(1L).first())
            print("Mostrando elementos después de borrar")
            itemDao.getAll().forEach {
                print(it.name)
            }
        }
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        abmDemo(applicationContext)
        setContentView(R.layout.activity_main)
    }
}