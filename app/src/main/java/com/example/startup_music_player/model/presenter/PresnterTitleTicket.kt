package com.example.startup_music_player.model.presenter

import com.example.startup_music_player.model.Contract.ContractTitleTicket
import com.example.startup_music_player.model.net.Apiservice

class PresnterTitleTicket(
    private val apiservice: Apiservice,
    private val Internet: Boolean,
) : ContractTitleTicket.PresenterTitle {
    var fragmentview: ContractTitleTicket.View? = null



    override suspend fun OnAttach(view: ContractTitleTicket.View) {
        fragmentview = view

        if (Internet){
            val data = apiservice.TitleTicket()
            view.titleTicket(data)
        }

    }

    override fun OnDetavh() {
    }


}