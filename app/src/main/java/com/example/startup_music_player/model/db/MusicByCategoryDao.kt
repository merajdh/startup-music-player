package com.example.startup_music_player.model.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.startup_music_player.model.data.MusicRespomse

@Dao
interface MusicByCategoryDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertOrUpdate(Music : List<MusicRespomse>)

    @Query("SELECT * FROM Musik_table")
    suspend fun getAll() : List<MusicRespomse>

    @Query("SELECT * FROM Musik_table WHERE id = :MusikId")
    suspend fun getByid(MusikId: String):MusicRespomse
}