package com.example.startup_music_player.model.data

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

@Entity("category_table")
data class CategoryRespomse (
    @SerializedName("title")
    val typeCategory : String,
    @SerializedName("image")
    val cover : String,

    @PrimaryKey
    @SerializedName("id")
    val id : String,

        )