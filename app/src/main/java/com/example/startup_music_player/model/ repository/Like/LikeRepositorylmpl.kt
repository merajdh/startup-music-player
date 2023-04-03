package com.example.startup_music_player.model.repository.Like


import com.example.startup_music_player.model.net.Apiservice
import com.google.gson.JsonObject
import ir.dunijet.dunibazaar.util.VALUE_SUCCESS

class LikeRepositorylmpl(
    private val apiservice: Apiservice,
) : LikeRepository {

    override suspend fun AddLike(id: String): String {
        val jsonObject = JsonObject().apply {
            addProperty("pk", id)
        }

        val result = apiservice.FavoritemusicAdd(jsonObject)
        if (result.status) {
            return VALUE_SUCCESS
        } else {
            return "error"
        }
    }
}