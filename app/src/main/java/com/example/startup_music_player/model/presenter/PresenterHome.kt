package com.example.startup_music_player.model.presenter

import com.example.startup_music_player.model.Contract.ContractHome
import com.example.startup_music_player.model.data.MusicRespomse
import com.example.startup_music_player.model.net.Apiservice

class PresenterHome(
    private val apiservice: Apiservice,
    private val  internet : Boolean
):ContractHome.Presenter {
    var fragmentview : ContractHome.View? = null

    override suspend fun OnAttach(view: ContractHome.View) {
        fragmentview = view
        if (internet){
            //   val data = apiservice.TopMusic()
         // fragmentview!!.ShowTopMusik("")
        }else{

        }

    }

    override  fun OnDetavh() {
        fragmentview = null
    }

}