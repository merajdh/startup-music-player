package com.example.startup_music_player.model.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.startup_music_player.model.data.*

@Dao
interface MusicByCategoryDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertOrUpdate(Music: List<MusicByCategoryRespomse>)

    @Query("SELECT * FROM MusicByCategory_table")
    fun getAllMusicByCategory(): List<MusicByCategoryRespomse>

    @Query("SELECT * FROM MusicByCategory_table WHERE id = :MusikId")
    fun getByidMusicByCategory(MusikId: String): MusicByCategoryRespomse

    @Query("DELETE FROM MusicByCategory_table")
    fun deletAllMusicByCategory()
}

@Dao
interface MoreLikeDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertOrUpdate(Music: List<MusicTopRespomse>)

    @Query("SELECT * FROM MusicTop_table")
    fun getAllMoreLike(): List<MusicTopRespomse>

    @Query("SELECT * FROM MusicTop_table WHERE id = :MusikId")
    fun getByidMoreLike(MusikId: String): MusicTopRespomse

    @Query("DELETE FROM MusicTop_table")
    fun deletAllMusicTop()
}

@Dao
interface RecentMusikDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertOrUpdate(Music: List<MusicNewsRespomse>)

    @Query("SELECT * FROM MusicNews_table")
    fun getAllRecentMusik(): List<MusicNewsRespomse>

    @Query("SELECT * FROM MusicNews_table WHERE id = :MusikId")
    fun getByidRecentMusikDao(MusikId: String): MusicNewsRespomse

    @Query("DELETE FROM MusicNews_table")
    fun deletAllMusicNews()
}

@Dao
interface TrendMusikDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertOrUpdate(Music: List<MusicTrendRespomse>)

    @Query("SELECT * FROM MusicTrend_table")
    fun getAllTrendMusik(): List<MusicTrendRespomse>

    @Query("SELECT * FROM MusicTrend_table WHERE id = :MusikId")
    fun getByidTrendMusik(MusikId: String): MusicTrendRespomse

    @Query("DELETE FROM MusicTrend_table")
    fun deletAllMusicTrend()
}

@Dao
interface internationalMusicDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertOrUpdate(Music: List<MusicInternatioalRespomse>)

    @Query("SELECT * FROM MusicInternatioal_table")
    fun getAllnternationalMusic(): List<MusicInternatioalRespomse>

    @Query("SELECT * FROM MusicInternatioal_table WHERE id = :MusikId")
    fun getByidnternationalMusic(MusikId: String): MusicInternatioalRespomse

    @Query("DELETE FROM MusicInternatioal_table")
    fun deletAllMusicInternatioal()
}

@Dao
interface CategoryDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertOrUpdate(Category: List<CategoryRespomse>)

    @Query("SELECT * FROM category_table")
    fun getAllCategory(): List<CategoryRespomse>

    @Query("SELECT * FROM category_table WHERE id = :CategoryId")
    fun getByIDCategory(CategoryId: String): CategoryRespomse

    @Query("DELETE FROM category_table")
    fun deletAllcategory()
}

@Dao
interface ArtistDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertOrUpdate(Category: List<ListArtistData>)

    @Query("SELECT * FROM Artist_Table")
    fun getAllCategory(): List<ListArtistData>

    @Query("SELECT * FROM Artist_Table WHERE id = :ArtistId")
    fun getByIDCategory(ArtistId: String): ListArtistData

    @Query("DELETE FROM Artist_Table")
    fun deletAllArtist()
}


