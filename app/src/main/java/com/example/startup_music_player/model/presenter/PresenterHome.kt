package com.example.startup_music_player.model.presenter

import com.example.startup_music_player.model.Contract.ContractHome
import com.example.startup_music_player.model.db.MusicByCategoryDao
import com.example.startup_music_player.model.net.Apiservice

class PresenterHome(
    private val apiservice: Apiservice,
    private val Internet :Boolean,
    private val MusicByCategoryDao : MusicByCategoryDao
):ContractHome.Presenter {
    var fragmentview : ContractHome.View? = null

    override suspend fun OnAttach(view: ContractHome.View) {
        fragmentview = view

        if (Internet){
            val data_MusicByCategory = apiservice.MusicByCategory()
            val data_Musicnewes = apiservice.MusicNews()
            val data_MusicTop = apiservice.MusicTop()
            val data_MusicTrend = apiservice.MusicTrend()
            val data_MusicInternational = apiservice.MusicInternatioal()
            MusicByCategoryDao.insertOrUpdate(apiservice.MusicByCategory())
            val test = MusicByCategoryDao.getAll()
            fragmentview!!.MusicByCategory(data_MusicByCategory)
            fragmentview!!.RecentMusik(data_Musicnewes)
            fragmentview!!.MoreLike(data_MusicTop)
            fragmentview!!.TrendMusik(data_MusicTrend)
            fragmentview!!.InternationalMusic(data_MusicInternational)
        }else{

        }

    }

    override  fun OnDetavh() {
        fragmentview = null
    }

}