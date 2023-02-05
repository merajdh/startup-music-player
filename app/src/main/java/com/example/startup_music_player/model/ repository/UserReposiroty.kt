package com.example.startup_music_player.model.repository

interface UserReposiroty {
    //Online
    suspend fun Login(username: String, password: String): String
    suspend fun Register(username: String, gmail: String, password: String): String
    suspend fun Verify(Verify_Code: String): String

    //Ofline
    fun singout()
    fun loadtoken()

    fun saveToken(newToken: String)
    fun getToken(): String

    fun saveusername(username: String)
    fun getusername(): String

}