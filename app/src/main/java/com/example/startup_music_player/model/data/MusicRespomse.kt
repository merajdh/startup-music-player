package com.example.startup_music_player.model.data


import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

@Entity("Musik_table")
data class MusicRespomse(
    @SerializedName("artist")
    val artist: ArrayList<String>,
    @SerializedName("category")
    val category: ArrayList<String>,
    @SerializedName("cover")
    val cover: String,

    @PrimaryKey
    @SerializedName("id")
    val id: Int,

    @SerializedName("text")
    val text: String,
    @SerializedName("title")
    val title: String,
    @SerializedName("url")
    val url: String
)