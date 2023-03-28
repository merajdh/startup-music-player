package com.example.startup_music_player.model.data

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

@Entity("Artist_Table")
data class ListArtistData (
    @SerializedName("name")
    val ArtistName : String,
    @SerializedName("image")
    val cover : String,

    @PrimaryKey
    @SerializedName("id")
    val id: Int,
)