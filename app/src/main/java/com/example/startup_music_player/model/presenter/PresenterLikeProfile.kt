package com.example.startup_music_player.model.presenter


import com.example.startup_music_player.model.Contract.ContractLikeProfile
import com.example.startup_music_player.model.net.Apiservice
import com.example.startup_music_player.model.repository.TokenInMemory
import com.example.startup_music_player.util.MyApp

class PresenterLikeProfile(
    private val apiservice: Apiservice,
    private val Internet: Boolean,
) : ContractLikeProfile.Presenter {
    var View: ContractLikeProfile.View? = null
    override suspend fun OnAttach(view: ContractLikeProfile.View) {
        if (Internet){
            View!!.ShowMusicLikeUser(apiservice.Favoritemusic(TokenInMemory.userid.toString()))
        }

    }

    override fun OnDetavh() {
        View = null

    }
}