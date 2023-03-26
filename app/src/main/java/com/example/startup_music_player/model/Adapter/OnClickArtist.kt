package com.example.startup_music_player.model.Adapter

import com.example.startup_music_player.model.data.DetailArtistRespomse

interface OnClickArtist {
    fun popularMusic(data:DetailArtistRespomse.PopularMusic)
    fun recentMusic(data : DetailArtistRespomse.RecentMusic)
}