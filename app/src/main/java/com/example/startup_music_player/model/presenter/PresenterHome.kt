package com.example.startup_music_player.model.presenter

import android.util.Log
import com.example.startup_music_player.model.Contract.ContractHome
import com.example.startup_music_player.model.db.*
import com.example.startup_music_player.model.net.Apiservice
import com.example.startup_music_player.util.MyApp

class PresenterHome(
    private val apiservice: Apiservice,
    private val Internet: Boolean,
    private val MusicByCategoryDao: MusicByCategoryDao,
    private val MoreLikeDao: MoreLikeDao,
    private val RecentMusikDao: RecentMusikDao,
    private val TrendMusikDao: TrendMusikDao,
    private val internationalMusicDao: internationalMusicDao
) : ContractHome.Presenter {
    var fragmentview: ContractHome.View? = null

    override suspend fun OnAttach(view: ContractHome.View) {
        fragmentview = view
        Ofline()
        if (Internet) {
          // data newe musik
            Online()

        } else {
            Ofline()
        }

    }

    override fun OnDetavh() {
        fragmentview = null
    }
    fun Ofline(){
        fragmentview!!.MusicByCategoryOf(MusicByCategoryDao.getAllMusicByCategory())
        fragmentview!!.MoreLikeOf(MoreLikeDao.getAllMoreLike())
        fragmentview!!.RecentMusikOf(RecentMusikDao.getAllRecentMusik())
        fragmentview!!.TrendMusikOf(TrendMusikDao.getAllTrendMusik())
        fragmentview!!.InternationalMusicOf(internationalMusicDao.getAllnternationalMusic())
    }
    suspend fun Online(){
        // insert ->
        MusicByCategoryDao.insertOrUpdate(apiservice.MusicByCategory())
        MoreLikeDao.insertOrUpdate(apiservice.MusicTop())
        RecentMusikDao.insertOrUpdate(apiservice.MusicNews())
        TrendMusikDao.insertOrUpdate(apiservice.MusicTrend())
        internationalMusicDao.insertOrUpdate(apiservice.MusicInternatioal())

        // send data To ui
        fragmentview!!.MusicByCategoryOn(MusicByCategoryDao.getAllMusicByCategory())
        fragmentview!!.MoreLikeOn(MoreLikeDao.getAllMoreLike())
        fragmentview!!.RecentMusikOn(RecentMusikDao.getAllRecentMusik())
        fragmentview!!.TrendMusikOn(TrendMusikDao.getAllTrendMusik())
        fragmentview!!.InternationalMusicOn(internationalMusicDao.getAllnternationalMusic())
    }
}