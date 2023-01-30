package com.example.startup_music_player.model.net

import com.example.startup_music_player.model.data.LoginRespomse
import com.example.startup_music_player.model.repository.TokenInMemory
import okhttp3.Authenticator
import okhttp3.Request
import okhttp3.Response
import okhttp3.Route
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject

class AuthChecker : Authenticator, KoinComponent {
    private val apiservice: Apiservice by inject()
    override fun authenticate(route: Route?, response: Response): Request? {
        if (TokenInMemory.Token != null && !response.request().url().pathSegments().last().equals("", false)) {
            val result = refreshToken()
            if (result) {
                return response.request()
            }
            return null
        }

    }

    private fun refreshToken(): Boolean {
        val request: retrofit2.Response<LoginRespomse> = apiservice.refreshToken().execute()
        if (request.body() != null) {
            if (request.body()!!.success) {
                return true
            }
        }
        return false
    }

}