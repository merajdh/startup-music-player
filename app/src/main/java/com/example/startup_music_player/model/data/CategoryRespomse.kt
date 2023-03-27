package com.example.startup_music_player.model.data

import com.google.gson.annotations.SerializedName

data class CategoryRespomse (
    @SerializedName("title")
    val typeCategory : String,
    @SerializedName("image")
    val cover : String,
    @SerializedName("id")
    val id : String,

        )