package com.example.startup_music_player.model.data


import com.google.gson.annotations.SerializedName

data class DetailArtistRespomse(
    @SerializedName("id")
    var id: Int,
    @SerializedName("image")
    var image: String,
    @SerializedName("music_quantity")
    var musicQuantity: Int,
    @SerializedName("name")
    var name: String,
    @SerializedName("popular_music")
    var popularMusic: List<PopularMusic>,
    @SerializedName("recent_music")
    var recentMusic: List<RecentMusic>
) {
    data class PopularMusic(
        @SerializedName("artist")
        var artist: List<String>,
        @SerializedName("cover")
        var cover: String,
        @SerializedName("id")
        var id: Int,
        @SerializedName("title")
        var title: String
    )

    data class RecentMusic(
        @SerializedName("artist")
        var artist: List<String>,
        @SerializedName("cover")
        var cover: String,
        @SerializedName("id")
        var id: Int,
        @SerializedName("title")
        var title: String
    )
}