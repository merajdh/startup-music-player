package com.example.startup_music_player.model.repository.ticket


import com.example.startup_music_player.model.net.Apiservice
import com.google.gson.JsonObject
import ir.dunijet.dunibazaar.util.VALUE_SUCCESS

class ticketrepositoryimpl(
    private val apiservice: Apiservice,
): ticketrepository {
    override suspend fun SendTicket(Ticket: String, Username: String, IdTicket: String): String {
        val jsonObject = JsonObject().apply {
            addProperty("body",Ticket)
            addProperty("user",Username)
            addProperty("pk",IdTicket)
        }
        val result = apiservice.SendTicket(jsonObject)
        if (result.success){
            return VALUE_SUCCESS
        }else{
            return result.message
        }
    }
}