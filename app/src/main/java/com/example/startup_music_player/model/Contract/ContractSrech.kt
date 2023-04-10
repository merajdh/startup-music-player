package com.example.startup_music_player.model.Contract

import com.example.startup_music_player.model.data.ListArtistData
import com.example.startup_music_player.model.data.CategoryRespomse
import com.example.startup_music_player.model.data.MusicRespomse

interface ContractSrech {

    interface PresenterSrech{
        suspend fun OnAttach(view:View)
        fun OnDetavh()
    }
    interface View {
        fun srech(data: List<MusicRespomse>)
    }
}