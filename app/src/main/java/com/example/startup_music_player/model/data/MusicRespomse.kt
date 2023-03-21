package com.example.startup_music_player.model.data


import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

@Entity("Musik_table")
data class MusicRespomse(
    @SerializedName("artist")
    val artist: List<String>,
    @SerializedName("cover")
    val cover: String,

    @PrimaryKey
    @SerializedName("id")
    val id: String,

    @SerializedName("title")
    val title: String
)