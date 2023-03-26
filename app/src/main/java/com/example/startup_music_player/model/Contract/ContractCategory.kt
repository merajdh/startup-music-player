package com.example.startup_music_player.model.Contract

import com.example.startup_music_player.model.data.ListArtistData
import com.example.startup_music_player.model.data.CategoryRespomse

interface ContractCategory {

    interface PresenterCategory{
        suspend fun OnAttach(view:View)
        fun OnDetavh()
    }
    interface View {
        fun TypeOfMusic(data: List<CategoryRespomse>)

        fun ListArtist(data: List<ListArtistData>)



    }
}