package com.example.startup_music_player.model.Contract

import com.example.startup_music_player.model.data.MusicRespomse

interface ContractLikeProfile {

    interface Presenter{
       suspend fun OnAttach(view : View)
        fun OnDetavh()
    }
    interface View{
        suspend fun ShowMusicLikeUser(data : List<MusicRespomse>)
    }
}