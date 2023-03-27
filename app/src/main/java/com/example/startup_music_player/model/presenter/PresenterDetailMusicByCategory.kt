package com.example.startup_music_player.model.presenter

import com.example.startup_music_player.model.Contract.ContractDetailMusicByCategory
import com.example.startup_music_player.model.net.Apiservice
import com.example.startup_music_player.util.MyApp

class PresenterDetailMusicByCategory(
    private val apiservice: Apiservice,
    private val Internet: Boolean,
) : ContractDetailMusicByCategory.PresenterMusicByCategory {
    var View: ContractDetailMusicByCategory.View? = null


    override suspend fun OnAttach(view: ContractDetailMusicByCategory.View) {
        View = view
        if (Internet){
            val data = apiservice.MusicByCategory(MyApp.idCategory)
            view.MusicByCategory(data)

        }
    }

    override fun OnDetavh() {
    }


}