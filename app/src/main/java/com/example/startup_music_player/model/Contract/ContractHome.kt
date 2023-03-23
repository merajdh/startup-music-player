package com.example.startup_music_player.model.Contract

import com.example.startup_music_player.model.data.MusicRespomse

interface ContractHome {

    interface Presenter{
       suspend fun OnAttach(view:ContractHome.View)
       fun OnDetavh()
    }
    interface View {
        //Online
        fun MusicByCategoryOn(data: List<MusicRespomse>)
        fun MoreLikeOn(data: List<MusicRespomse>)
        fun RecentMusikOn(data: List<MusicRespomse>)
        fun TrendMusikOn(data: List<MusicRespomse>)
        fun InternationalMusicOn(data: List<MusicRespomse>)

        //Ofline
        fun MusicByCategoryOf(data: List<MusicRespomse>)
        fun MoreLikeOf(data: List<MusicRespomse>)
        fun RecentMusikOf(data: List<MusicRespomse>)
        fun TrendMusikOf(data: List<MusicRespomse>)
        fun InternationalMusicOf(data: List<MusicRespomse>)
    }
}