package com.example.startup_music_player.model.repository

interface UserReposiroty {
    //Online
    suspend fun Login(username: String, password: String): String
    suspend fun Register(username: String, gmail: String, password: String): String
    suspend fun Verify(Verify_Code: String): String
    suspend fun updatepassword(old_password :String,new_password : String): String

    //Ofline
    fun singout()

    fun loadToken()

    fun saveToken(newToken: String)
    fun getToken(): String?

    fun saveUserName(username: String)
    fun getUserName(): String?

    fun saveRefresh(refresh: String?)
    fun getRefresh(): String?

    fun saveIduser(id: String?)
    fun getIduser(): String?






}