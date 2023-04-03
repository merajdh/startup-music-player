package com.example.startup_music_player.model.InteFaces

import com.example.startup_music_player.model.data.DetailArtistRespomse
import com.example.startup_music_player.model.data.CategoryRespomse
import com.example.startup_music_player.model.data.ListArtistData

interface OnClickCategory {
    fun ClickCategory(data : CategoryRespomse)
    fun OnClickArtist(data: ListArtistData)

}