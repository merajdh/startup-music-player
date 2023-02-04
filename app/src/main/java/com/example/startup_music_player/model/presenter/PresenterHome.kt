package com.example.startup_music_player.model.presenter

import android.util.Log
import com.example.startup_music_player.model.Contract.ContractHome
import com.example.startup_music_player.model.net.Apiservice

class PresenterHome(
    private val apiservice: Apiservice,
):ContractHome.Presenter {
    var fragmentview : ContractHome.View? = null

    override suspend fun OnAttach(view: ContractHome.View) {
        fragmentview = view
//        val data = apiservice.TopMusic()
        fragmentview!!.ShowTopMusik("data_Abol")
    }

    override  fun OnDetavh() {
        fragmentview = null
    }

    override suspend fun OnClikt() {

    }
}