package com.brianvega.ucm_app.models

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.brianvega.ucm_app.Constants
import com.brianvega.ucm_app.MainApp
import com.brianvega.ucm_app.models.converters.ConvertersDate
import com.brianvega.ucm_app.models.hero.Hero
import com.brianvega.ucm_app.models.hero.HeroDao
import com.brianvega.ucm_app.models.movie.Movie
import com.brianvega.ucm_app.models.movie.MovieDao

@Database(
    entities = [
        Hero::class,
        Movie::class
    ], version = 1
)
@TypeConverters(ConvertersDate::class)
abstract class DataBase : RoomDatabase() {

    abstract fun heroDao(): HeroDao

    abstract fun movieDao(): MovieDao

    companion object {

        private var INSTANCE: DataBase? = null

        fun getDataBase(): DataBase {
            if (INSTANCE == null) {
                INSTANCE = create(MainApp.instance.applicationContext!!)
            }
            return INSTANCE as DataBase
        }

        private fun create (context: Context): DataBase {
            return Room.databaseBuilder(context, DataBase::class.java,
                Constants.NAME_DATA_BASE)
                .build()
        }

    }

}