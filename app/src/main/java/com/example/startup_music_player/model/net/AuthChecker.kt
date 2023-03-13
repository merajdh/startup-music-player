package com.example.startup_music_player.model.net


import android.util.Log
import com.example.startup_music_player.model.repository.TokenInMemory
import com.google.gson.JsonObject
import okhttp3.Authenticator
import okhttp3.Request
import okhttp3.Response
import okhttp3.Route
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject

class AuthChecker : Authenticator, KoinComponent {
    private val apiservice: Apiservice by inject()
    override fun authenticate(route: Route?, response: Response): Request? {
        // is Chekt error 405
        val jsonObject = JsonObject().apply {
            addProperty("refresh", TokenInMemory.refresh)
        }

        val result = apiservice.refreshToken(jsonObject)
        Log.v("token",result.access)
        TokenInMemory.access = result.access

        return null
    }



}