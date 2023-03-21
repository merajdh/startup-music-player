package com.example.startup_music_player.model.presenter

import com.example.startup_music_player.model.Contract.ContractPlayMusic
import com.example.startup_music_player.model.net.Apiservice
import com.example.startup_music_player.util.MyApp

class PresenterPlayMusic(
    private val apiservice: Apiservice,
    private val Internet: Boolean,
) : ContractPlayMusic.Presenter {
    var View: ContractPlayMusic.View? = null


    override suspend fun OnAttach(view: ContractPlayMusic.View) {
        View = view
        if (Internet){
            val data = apiservice.MusicPlay(MyApp.idMusic)
            view.PlayMusic(data)
        }

    }

    override fun OnDetavh() {
        TODO("Not yet implemented")
    }


}