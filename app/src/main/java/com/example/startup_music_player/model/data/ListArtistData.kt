package com.example.startup_music_player.model.data

import com.google.gson.annotations.SerializedName

data class ListArtistData (
    @SerializedName("name")
    val ArtistName : String,
    @SerializedName("image")
    val cover : String,
    @SerializedName("id")
    val id: Int,
)