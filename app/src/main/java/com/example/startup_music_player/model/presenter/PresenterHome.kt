package com.example.startup_music_player.model.presenter

import com.example.startup_music_player.model.Contract.ContractHome
import com.example.startup_music_player.model.db.MusicByCategoryDao
import com.example.startup_music_player.model.net.Apiservice

class PresenterHome(
    private val apiservice: Apiservice,
    private val Internet: Boolean,
    private val MusicByCategoryDao: MusicByCategoryDao
) : ContractHome.Presenter {
    var fragmentview: ContractHome.View? = null

    override suspend fun OnAttach(view: ContractHome.View) {
        fragmentview = view

        if (Internet) {


// data newe musik
            MusicByCategoryDao.insertOrUpdate(apiservice.MusicNews())
            fragmentview!!.RecentMusik(MusicByCategoryDao.getAll())

        } else {

        }

    }

    override fun OnDetavh() {
        fragmentview = null
    }

}