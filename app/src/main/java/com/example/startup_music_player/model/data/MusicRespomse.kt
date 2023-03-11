package com.example.startup_music_player.model.data


import com.google.gson.annotations.SerializedName

data class MusicRespomse(
    @SerializedName("artist")
    val artist: List<String>,
    @SerializedName("cover")
    val cover: String,
    @SerializedName("id")
    val id: Int,
    @SerializedName("title")
    val title: String
)