package com.example.startup_music_player.model.net

import android.util.Log
import com.example.startup_music_player.model.data.LoginRespomse
import com.google.gson.JsonObject
import retrofit2.http.Body
import retrofit2.http.POST

interface Apiservice {

    @POST("")
   suspend fun Login(@Body jsonObject: JsonObject) : LoginRespomse

    @POST("")
    suspend fun Register(@Body jsonObject: JsonObject) : LoginRespomse
}