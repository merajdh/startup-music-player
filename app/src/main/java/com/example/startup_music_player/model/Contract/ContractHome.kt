package com.example.startup_music_player.model.Contract

import com.example.startup_music_player.model.data.MusicRespomse

interface ContractHome {

    interface Presenter{
       suspend fun OnAttach(view:ContractHome.View)
       fun OnDetavh()
    }
    interface View {
        fun MusicByCategory(data: List<MusicRespomse>)
        fun MoreLike(data: List<MusicRespomse>)
        fun RecentMusik(data: List<MusicRespomse>)
        fun TrendMusik(data: List<MusicRespomse>)
        fun InternationalMusic(data: List<MusicRespomse>)
    }
}