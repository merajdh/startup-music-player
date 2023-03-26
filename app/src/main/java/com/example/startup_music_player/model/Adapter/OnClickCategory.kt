package com.example.startup_music_player.model.Adapter

import com.example.startup_music_player.model.data.ArtistData
import com.example.startup_music_player.model.data.CategoryRespomse

interface OnClickCategory {
    fun ClickCategory(data : CategoryRespomse)
    fun OnClickArtist(data: ArtistData)

}