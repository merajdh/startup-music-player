package com.example.startup_music_player.model.presenter

import com.example.startup_music_player.model.Contract.ContractCategory
import com.example.startup_music_player.model.Contract.ContractHome
import com.example.startup_music_player.model.Contract.ContractPlayMusic
import com.example.startup_music_player.model.data.CategoryRespomse
import com.example.startup_music_player.model.net.Apiservice
import com.example.startup_music_player.util.MyApp

class PresenterCategory(
    private val apiservice: Apiservice,
    private val Internet :Boolean,

):ContractCategory.PresenterCategory {
    var fragmentview : ContractCategory.View? = null


    override suspend fun OnAttach(view: ContractCategory.View) {
        fragmentview = view

        if (Internet){
            val data_TypeMusicCategory = apiservice.CategoryTypeMusic()
            val data_ArtistCategory = apiservice.CategoryArtist()


            fragmentview!!.TypeOfMusic(data_TypeMusicCategory)
            fragmentview!!.Artist(data_ArtistCategory)

        }else{

        }

    }

    override  fun OnDetavh() {
        fragmentview = null
    }

}