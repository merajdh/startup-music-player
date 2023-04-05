package com.example.startup_music_player.model.Contract

import com.example.startup_music_player.model.data.TitleTicket

interface ContractTitleTicket {
    interface PresenterTitle{
        suspend fun OnAttach(view: ContractTitleTicket.View)
        fun OnDetavh()
    }

    interface View{
        fun titleTicket(ticket: List<TitleTicket>)

    }
}