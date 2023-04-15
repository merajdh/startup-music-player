package com.example.startup_music_player.model.data


import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

data class MusicRespomse(
    @SerializedName("artist")
    val artist: ArrayList<String>,
    @SerializedName("cover")
    val cover: String,
    @SerializedName("id")
    val id: Int,
    @SerializedName("title")
    val title: String, )

//-------------------------------------------
@Entity("MusicByCategory_table")
data class MusicByCategoryRespomse(
    @SerializedName("artist")
    val artist: ArrayList<String>,

    @SerializedName("cover")
    val cover: String,

    @PrimaryKey
    @SerializedName("id")
    val id: Int,


    @SerializedName("title")
    val title: String,

    @SerializedName("category_name")
    val category_name: String,

)
//-------------------------------------------
@Entity("MusicNews_table")
data class MusicNewsRespomse(
    @SerializedName("artist")
    val artist: ArrayList<String>,

    @SerializedName("cover")
    val cover: String,

    @PrimaryKey
    @SerializedName("id")
    val id: Int,


    @SerializedName("title")
    val title: String,

    )
//-------------------------------------------
@Entity("MusicTop_table")
data class MusicTopRespomse(
    @SerializedName("artist")
    val artist: ArrayList<String>,

    @SerializedName("cover")
    val cover: String,

    @PrimaryKey
    @SerializedName("id")
    val id: Int,


    @SerializedName("title")
    val title: String,

    )

//-------------------------------------------
@Entity("MusicTrend_table")
data class MusicTrendRespomse(
    @SerializedName("artist")
    val artist: ArrayList<String>,

    @SerializedName("cover")
    val cover: String,

    @PrimaryKey
    @SerializedName("id")
    val id: Int,


    @SerializedName("title")
    val title: String,

    )
//-------------------------------------------

@Entity("MusicInternatioal_table")
data class MusicInternatioalRespomse(
    @SerializedName("artist")
    val artist: ArrayList<String>,

    @SerializedName("cover")
    val cover: String,

    @PrimaryKey
    @SerializedName("id")
    val id: Int,

    @SerializedName("title")
    val title: String,

    )