package com.example.startup_music_player.model.net


import android.util.Log
import com.example.startup_music_player.model.data.LoginRespomse
import com.example.startup_music_player.model.repository.TokenInMemory
import com.example.startup_music_player.model.repository.UserReposiroty
import com.google.gson.JsonObject
import okhttp3.Authenticator
import okhttp3.Request
import okhttp3.Response
import okhttp3.Route
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject

class AuthChecker : Authenticator, KoinComponent {
    private val apiservice: Apiservice by inject()
    private val UserReposiroty: UserReposiroty by inject()
    override fun authenticate(route: Route?, response: Response): Request? {
        // is Chekt error 401
        Log.v("test","11228")
        if (TokenInMemory.access!=""&&TokenInMemory.refresh!=""&& !response.request.url.pathSegments.last().equals("access",false)){
            try {
                val access = refreshToken()
                if (access.isEmpty())
                    return null
                return response.request.newBuilder().header("Authorization","Bearer $access").build()
            }catch (exception : Exception){
                Log.v("exception",exception.toString())
            }
        }

        return null
    }


    fun refreshToken(): String {
        val response : retrofit2.Response<LoginRespomse> = apiservice.refreshToken(JsonObject().apply {
            addProperty("refresh",TokenInMemory.refresh)
        }).execute()

        response.body()?.let {
            TokenInMemory.refreshToken(null,it.access,it.refresh)
            UserReposiroty.saveToken(it.access)
            UserReposiroty.saveRefresh(it.refresh)
            return it.access
        }


        return ""
    }

}