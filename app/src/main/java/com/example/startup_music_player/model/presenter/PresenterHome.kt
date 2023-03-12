package com.example.startup_music_player.model.presenter

import com.example.startup_music_player.model.Contract.ContractHome
import com.example.startup_music_player.model.net.Apiservice

class PresenterHome(
    private val apiservice: Apiservice,
    private val Internet :Boolean
):ContractHome.Presenter {
    var fragmentview : ContractHome.View? = null

    override suspend fun OnAttach(view: ContractHome.View) {
        fragmentview = view

        if (Internet){
            val data_MusicByCategory = apiservice.MusicByCategory()
            val data_Musicnewes = apiservice.MusicNews()
            val data_MusicTop = apiservice.MusicTop()
            val data_MusicTrend = apiservice.MusicTrend()

            fragmentview!!.MusicByCategory(data_MusicByCategory)
            fragmentview!!.RecentMusik(data_Musicnewes)
            fragmentview!!.MoreLike(data_MusicTop)
            fragmentview!!.TrendMusik(data_MusicTrend)
        }else{

        }

    }

    override  fun OnDetavh() {
        fragmentview = null
    }

}