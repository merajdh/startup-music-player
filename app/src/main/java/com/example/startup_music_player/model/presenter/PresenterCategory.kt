package com.example.startup_music_player.model.presenter

import android.util.Log
import com.example.startup_music_player.model.Contract.ContractCategory
import com.example.startup_music_player.model.Contract.ContractHome
import com.example.startup_music_player.model.Contract.ContractPlayMusic
import com.example.startup_music_player.model.data.CategoryRespomse
import com.example.startup_music_player.model.db.ArtistDao
import com.example.startup_music_player.model.db.CategoryDao
import com.example.startup_music_player.model.net.Apiservice
import com.example.startup_music_player.util.MyApp

class PresenterCategory(
    private val apiservice: Apiservice,
    private val Internet :Boolean,
    private val CategoryDao : CategoryDao,
    private val ArtistDAo : ArtistDao
):ContractCategory.PresenterCategory {
    var fragmentview : ContractCategory.View? = null


    override suspend fun OnAttach(view: ContractCategory.View) {
        fragmentview = view
        fragmentview!!.TypeOfMusic(CategoryDao.getAllCategory())
        fragmentview!!.ListArtist(ArtistDAo.getAllCategory())

        if (Internet){
            CategoryDao.insertOrUpdate(apiservice.CategoryTypeMusic())
            ArtistDAo.insertOrUpdate(apiservice.CategoryArtist())
            fragmentview!!.TypeOfMusic(CategoryDao.getAllCategory())
            fragmentview!!.ListArtist(ArtistDAo.getAllCategory())

        }else{

        }

    }

    override  fun OnDetavh() {
        fragmentview = null
    }

}