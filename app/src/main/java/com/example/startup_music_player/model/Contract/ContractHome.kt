package com.example.startup_music_player.model.Contract

import com.example.startup_music_player.model.data.MusicRespomse

interface ContractHome {

    interface Presenter{
       suspend fun OnAttach(view:View)
       fun OnDetavh()
    }
    interface View {
        fun ShowPartiMusik(data: List<MusicRespomse>)
        fun ShowTopMusik(data: List<MusicRespomse>)
        fun ShowTopViewMusik(data: List<MusicRespomse>)
        fun ShowGuropMusik(data: List<MusicRespomse>)
    }
}