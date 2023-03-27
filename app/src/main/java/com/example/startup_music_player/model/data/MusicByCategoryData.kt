package com.example.startup_music_player.model.data


import com.google.gson.annotations.SerializedName

data class MusicByCategoryData(
    @SerializedName("artist")
    var artist: List<String>,
    @SerializedName("cover")
    var cover: String,
    @SerializedName("id")
    var id: Int,
    @SerializedName("title")
    var title: String
)
