package com.example.startup_music_player.model.data


import com.google.gson.annotations.SerializedName

data class MusicDetail(
    @SerializedName("artist")
    val artist: List<Artist>,
    @SerializedName("category")
    val category: List<Category>,
    @SerializedName("cover")
    val cover: String,
    @SerializedName("id")
    val id: Int,
    @SerializedName("text")
    val text: String,
    @SerializedName("title")
    val title: String,
    @SerializedName("url")
    val url: String
) {
    data class Artist(
        @SerializedName("id")
        val id: Int,
        @SerializedName("name")
        val name: String
    )

    data class Category(
        @SerializedName("id")
        val id: Int,
        @SerializedName("title")
        val title: String
    )
}