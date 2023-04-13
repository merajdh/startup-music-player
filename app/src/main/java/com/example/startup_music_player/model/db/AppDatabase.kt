package com.example.startup_music_player.model.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.example.startup_music_player.model.data.*

@Database(
    version = 1,
    entities = [MusicByCategoryRespomse::class,MusicNewsRespomse::class,MusicTopRespomse::class,MusicTrendRespomse::class,MusicInternatioalRespomse::class, CategoryRespomse::class, ListArtistData::class],
    exportSchema = true,
)
@TypeConverters(Converters::class)
abstract class AppDatabase : RoomDatabase() {

    abstract val MusicByCategoryDao: MusicByCategoryDao
    abstract val MoreLikeDao: MoreLikeDao
    abstract val RecentMusikDao: RecentMusikDao
    abstract val TrendMusikDao: TrendMusikDao
    abstract val internationalMusicDao: internationalMusicDao
    abstract val Category: CategoryDao
    abstract val Artist: ArtistDao


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