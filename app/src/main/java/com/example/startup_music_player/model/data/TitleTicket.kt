package com.example.startup_music_player.model.data


import com.google.gson.annotations.SerializedName

    data class TitleTicket(
        @SerializedName("id")
        var id: Int,
        @SerializedName("title")
        var title: String
    )