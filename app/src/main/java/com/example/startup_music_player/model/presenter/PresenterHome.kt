package com.example.startup_music_player.model.presenter

import android.util.Log
import com.example.startup_music_player.model.Contract.ContractHome
import com.example.startup_music_player.model.net.Apiservice

class PresenterHome(
    private val apiservice: Apiservice,
    private val  internet : Boolean
):ContractHome.Presenter {
    var fragmentview : ContractHome.View? = null

    override suspend fun OnAttach(view: ContractHome.View)  {
        fragmentview = view
        if (internet){
        val data_MusicByCategory = apiservice.MusicByCategory()
        val data_MoreLike = apiservice.MoreLike()
        val data_RecentMusik = apiservice.RecentMusik()
        val data_TrendMusik = apiservice.TrendMusik()
         fragmentview!!.MusicByCategory(data_MusicByCategory)

        }else{
        }

    }

    override  fun OnDetavh() {
        fragmentview = null
    }

}