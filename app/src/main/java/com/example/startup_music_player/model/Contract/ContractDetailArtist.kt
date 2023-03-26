package com.example.startup_music_player.model.Contract

import com.example.startup_music_player.model.data.DetailArtistRespomse


interface ContractDetailArtist {

    interface PresenterArtist{
        suspend fun OnAttach(view:View)
        fun OnDetavh()
    }
    interface View {

        fun DetailArtist(data : DetailArtistRespomse)

    }
}