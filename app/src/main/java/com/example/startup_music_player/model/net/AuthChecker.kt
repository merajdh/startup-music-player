package com.example.startup_music_player.model.net

import com.example.startup_music_player.model.repository.TokenInMemory
import okhttp3.Authenticator
import okhttp3.Request
import okhttp3.Response
import okhttp3.Route
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject

class AuthChecker : Authenticator ,KoinComponent {
    private val apiservice : Apiservice by inject()
    override fun authenticate(route: Route?, response: Response): Request? {
        if(TokenInMemory.Token !=null){

        }
    }

    private fun tefreshToken(){}

}