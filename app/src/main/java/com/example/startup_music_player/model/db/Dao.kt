package com.example.startup_music_player.model.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.startup_music_player.model.data.CategoryRespomse
import com.example.startup_music_player.model.data.ListArtistData
import com.example.startup_music_player.model.data.MusicRespomse

@Dao
interface MusicByCategoryDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertOrUpdate(Music: List<MusicRespomse>)

    @Query("SELECT * FROM Musik_table")
    fun getAllMusicByCategory(): List<MusicRespomse>

    @Query("SELECT * FROM Musik_table WHERE id = :MusikId")
    fun getByidMusicByCategory(MusikId: String): MusicRespomse
}

@Dao
interface MoreLikeDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertOrUpdate(Music: List<MusicRespomse>)

    @Query("SELECT * FROM Musik_table")
    fun getAllMoreLike(): List<MusicRespomse>

    @Query("SELECT * FROM Musik_table WHERE id = :MusikId")
    fun getByidMoreLike(MusikId: String): MusicRespomse
}

@Dao
interface RecentMusikDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertOrUpdate(Music: List<MusicRespomse>)

    @Query("SELECT * FROM Musik_table")
    fun getAllRecentMusik(): List<MusicRespomse>

    @Query("SELECT * FROM Musik_table WHERE id = :MusikId")
    fun getByidRecentMusikDao(MusikId: String): MusicRespomse
}

@Dao
interface TrendMusikDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertOrUpdate(Music: List<MusicRespomse>)

    @Query("SELECT * FROM Musik_table")
    fun getAllTrendMusik(): List<MusicRespomse>

    @Query("SELECT * FROM Musik_table WHERE id = :MusikId")
    fun getByidTrendMusik(MusikId: String): MusicRespomse
}

@Dao
interface internationalMusicDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertOrUpdate(Music: List<MusicRespomse>)

    @Query("SELECT * FROM Musik_table")
    fun getAllnternationalMusic(): List<MusicRespomse>

    @Query("SELECT * FROM Musik_table WHERE id = :MusikId")
    fun getByidnternationalMusic(MusikId: String): MusicRespomse
}

@Dao
interface CategoryDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertOrUpdate(Category: List<CategoryRespomse>)

    @Query("SELECT * FROM category_table")
    fun getAllCategory(): List<CategoryRespomse>

    @Query("SELECT * FROM category_table WHERE id = :CategoryId")
    fun getByIDCategory(CategoryId: String): CategoryRespomse
}

@Dao
interface ArtistDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertOrUpdate(Category: List<ListArtistData>)

    @Query("SELECT * FROM Artist_Table")
    fun getAllCategory(): List<ListArtistData>

    @Query("SELECT * FROM Artist_Table WHERE id = :ArtistId")
    fun getByIDCategory(ArtistId: String): ListArtistData
}


