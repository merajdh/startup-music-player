package com.example.startup_music_player.model.Contract

import com.example.startup_music_player.model.data.MusicByCategoryData


interface ContractDetailMusicByCategory {

    interface PresenterMusicByCategory{
        suspend fun OnAttach(view:View)
        fun OnDetavh()
    }
    interface View {

        fun MusicByCategory(data : List<MusicByCategoryData>)

    }
}