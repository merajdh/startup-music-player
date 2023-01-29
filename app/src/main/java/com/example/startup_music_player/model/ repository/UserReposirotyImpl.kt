package com.example.startup_music_player.model.repository

import android.content.SharedPreferences
import com.example.startup_music_player.model.net.Apiservice
import com.google.gson.JsonObject

class UserReposirotyImpl(
    private val apiservice: Apiservice,
    private val sharedPref: SharedPreferences
) : UserReposiroty {


    override suspend fun Register(username: String, gmail: String, password: String): String {
        val jsonObject = JsonObject().apply {
            addProperty("name", username)
            addProperty("gmail", gmail)
            addProperty("password", password)
        }

        val result = apiservice.Register(jsonObject)
        if (result.success) {
            TokenInMemory.refreshToken(username, result.token)
            saveToken(result.token)
            saveusername(username)
            return "success"
        } else {
            return result.mesage
        }
    }

    override suspend fun Login(username: String, password: String): String {
        val jsonObject = JsonObject().apply {
            addProperty("name", username)
            addProperty("password", password)
        }
        val result = apiservice.Login(jsonObject)
        if (result.success) {
            TokenInMemory.refreshToken(username, result.token)
            saveToken(result.token)
            saveusername(username)
            return "success"
        } else {
            return result.mesage
        }
    }

    override fun singout() {

    }

    override fun loadtoken() {

    }

    override fun saveToken(newToken: String) {

    }

    override fun getToken(): String {
        return ""
    }

    override fun saveusername(username: String) {

    }

    override fun getusername(): String {
        return ""
    }
}