package com.example.startup_music_player.model.Contract

import com.example.startup_music_player.model.data.*

interface ContractHome {

    interface Presenter{
       suspend fun OnAttach(view:View)
       fun OnDetavh()
    }
    interface View {
        //Online
        fun MusicByCategoryOn(data: List<MusicByCategoryRespomse>)
        fun MoreLikeOn(data: List<MusicTopRespomse>)
        fun RecentMusikOn(data: List<MusicNewsRespomse>)
        fun TrendMusikOn(data: List<MusicTrendRespomse>)
        fun InternationalMusicOn(data: List<MusicInternatioalRespomse>)

        //Ofline
        fun MusicByCategoryOf(data: List<MusicByCategoryRespomse>)
        fun MoreLikeOf(data: List<MusicTopRespomse>)
        fun RecentMusikOf(data: List<MusicNewsRespomse>)
        fun TrendMusikOf(data: List<MusicTrendRespomse>)
        fun InternationalMusicOf(data: List<MusicInternatioalRespomse>)
    }
}