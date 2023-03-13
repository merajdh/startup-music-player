package com.example.startup_music_player.model.repository

object TokenInMemory {
    var username : String? = null
    private set

    var refresh : String? = null
    private set

    var access :String? = null

    fun refreshToken(Username:String? , newToken:String? , refreshToken:String?){
        this.username = Username
        this.access = newToken
        this.refresh = refreshToken
    }
}