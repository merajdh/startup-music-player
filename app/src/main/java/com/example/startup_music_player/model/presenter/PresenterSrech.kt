package com.example.startup_music_player.model.presenter

import android.util.Log
import com.example.startup_music_player.model.Contract.ContractCategory
import com.example.startup_music_player.model.Contract.ContractHome
import com.example.startup_music_player.model.Contract.ContractPlayMusic
import com.example.startup_music_player.model.Contract.ContractSrech
import com.example.startup_music_player.model.data.CategoryRespomse
import com.example.startup_music_player.model.db.ArtistDao
import com.example.startup_music_player.model.db.CategoryDao
import com.example.startup_music_player.model.net.Apiservice
import com.example.startup_music_player.util.MyApp

class PresenterSrech(
    private val apiservice: Apiservice,
    private val Internet :Boolean,
):ContractSrech.PresenterSrech {
    var fragmentview : ContractSrech.View? = null


    override suspend fun OnAttach(view: ContractSrech.View) {
        fragmentview = view

        if (Internet){
            fragmentview!!.srech(apiservice.search(MyApp.musicserch))

        }else{

        }

    }

    override  fun OnDetavh() {
        fragmentview = null
    }

}