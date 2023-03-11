package com.example.startup_music_player.model.presenter

import com.example.startup_music_player.model.Contract.ContractHome
import com.example.startup_music_player.model.net.Apiservice

class PresenterHome(
    private val apiservice: Apiservice,
    private val  internet : Boolean
):ContractHome.Presenter {
    var fragmentview : ContractHome.View? = null

    override suspend fun OnAttach(view: ContractHome.View)  {
        fragmentview = view

       val data_MusicByCategory = apiservice.MusicByCategory()
       val data_Musicnewes = apiservice.MusicNews()

        fragmentview!!.MusicByCategory(data_MusicByCategory)
        fragmentview!!.RecentMusik(data_Musicnewes)

    }

    override  fun OnDetavh() {
        fragmentview = null
    }

}