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
        Ofline()

        if (Internet) {
          // data newe musik
            Online()

        } else { Ofline() }

    }

    override fun OnDetavh() {
        fragmentview = null
    }
    fun Ofline(){
        fragmentview!!.MusicByCategoryOf(MusicByCategoryDao.getAllMusicByCategory())
    }
    suspend fun Online(){
        MusicByCategoryDao.insertOrUpdate(apiservice.MusicNews())
        fragmentview!!.RecentMusikOn(MusicByCategoryDao.getAllMusicByCategory())
    }
}