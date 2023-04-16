package com.example.startup_music_player.model.repository.ticket

interface ticketrepository {

    suspend fun SendTicket(Ticket : String,Username:String,IdTicket:String) : String
}