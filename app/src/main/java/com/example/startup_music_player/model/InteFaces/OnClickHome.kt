package com.example.startup_music_player.model.InteFaces

import com.example.startup_music_player.model.data.*

interface OnClickHome{
    fun Click_MusicByCategory(data: MusicByCategoryRespomse)
    fun Click_MusicTop(data: MusicTopRespomse)
    fun Click_MusicNews(data: MusicNewsRespomse)
    fun Click_MusicTrend(data: MusicTrendRespomse)
    fun Click_MusicInternatioal(data: MusicInternatioalRespomse)
}