package com.example.startup_music_player.model.repository

object TokenInMemory {
    var username : String? =null
    private set

    var refresh : String? =null
        private set

    var Token :String? =null
    private set

    fun refreshToken(Username:String? , newToken:String? , refreshToken:String?){
        this.username = Username
        this.Token = newToken
        this.refresh = refreshToken
    }
}