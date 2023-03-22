package com.example.startup_music_player.model.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.example.startup_music_player.model.data.MusicRespomse

@Database(version =1, entities = [MusicRespomse::class], exportSchema = true,)
@TypeConverters(Converters::class)
abstract class AppDatabase:RoomDatabase() {

    abstract val MusicByCategoryDao : MusicByCategoryDao


    companion object {


        private val INSTANCE: AppDatabase? = null

        fun getDatabes(context: Context): AppDatabase {
            synchronized(this) {
                var instans = INSTANCE
                if (instans == null) {
                    instans = Room.databaseBuilder(
                        context.applicationContext,
                        AppDatabase::class.java,
                        "myDatabase.db",
                    )
                        .allowMainThreadQueries()
                        .build()
                }
                return instans
            }
        }

    }
}