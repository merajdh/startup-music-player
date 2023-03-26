package com.example.startup_music_player.model.presenter

import com.example.startup_music_player.model.Contract.ContractDetailArtist
import com.example.startup_music_player.model.net.Apiservice
import com.example.startup_music_player.util.MyApp

class PresenterDetailArtist(
    private val apiservice: Apiservice,
    private val Internet: Boolean,
) : ContractDetailArtist.PresenterArtist {
    var View: ContractDetailArtist.View? = null


    override suspend fun OnAttach(view: ContractDetailArtist.View) {
        View = view
        if (Internet){
            val data = apiservice.ArtistDetail(MyApp.idArtist)
            view.DetailArtist(data)

        }
    }

    override fun OnDetavh() {
    }


}