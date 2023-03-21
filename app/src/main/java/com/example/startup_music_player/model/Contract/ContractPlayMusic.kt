package com.example.startup_music_player.model.Contract

import com.example.startup_music_player.model.data.MusicRespomse

interface ContractPlayMusic {

    interface Presenter{
        suspend fun OnAttach(view: ContractPlayMusic.View)
        fun OnDetavh()
    }

    interface View{
        fun PlayMusic(Music : MusicRespomse)

    }
}