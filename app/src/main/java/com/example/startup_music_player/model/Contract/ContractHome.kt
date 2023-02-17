package com.example.startup_music_player.model.Contract

import com.example.startup_music_player.model.data.MusicRespomse

interface ContractHome {

    interface Presenter{
       suspend fun OnAttach(view:View)
       fun OnDetavh()
       suspend fun OnClikt()
    }
    interface View {
        fun ShowPartiMusik(data: String)
        fun ShowTopMusik(data: String)
        fun ShowTopViewMusik(data: String)
        fun ShowGuropMusik(data: String)
    }
}