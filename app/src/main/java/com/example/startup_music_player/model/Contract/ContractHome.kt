package com.example.startup_music_player.model.Contract

import com.example.startup_music_player.ui.features.Home.HomeFragment

interface ContractHome {

    interface Presenter{
        fun OnAttach(view:HomeFragment)
        fun OnDetavh()
        fun OnClikt()
    }
    interface View {
        fun ShowPartiMusik()
        fun ShowTopMusik()
        fun ShowTopViewMusik()
        fun ShowGuropMusik()
    }
}