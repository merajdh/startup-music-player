package com.example.startup_music_player.model.repository

import android.content.SharedPreferences
import com.example.startup_music_player.model.net.Apiservice
import com.example.startup_music_player.model.repository.TokenInMemory.username
import com.google.gson.JsonObject
import ir.dunijet.dunibazaar.util.VALUE_SUCCESS

class UserReposirotyImpl(
    private val apiservice: Apiservice,
    private val sharedPref: SharedPreferences

) : UserReposiroty {


    override suspend fun Register(username: String, gmail: String, password: String): String {
        val jsonObject = JsonObject().apply {
            addProperty("username", username)
            addProperty("email", gmail)
            addProperty("password", password)
        }

        val result = apiservice.Register(jsonObject)
        if (result.success) {
            return VALUE_SUCCESS
        } else {
            return result.mesage
        }
    }

    override suspend fun Verify(Verify_Code: String): String {
        val jsonObject = JsonObject().apply {
            addProperty("code", Verify_Code)
        }

        val result = apiservice.Verify(jsonObject)
        if (result.success) {
            TokenInMemory.refreshToken(username, result.access,result.refresh)
            saveToken(result.access)
            saveRefresh(result.refresh)
            saveUserName(username.toString())
            saveRefresh(result.refresh)

            return VALUE_SUCCESS
        } else {
            return result.mesage
        }
    }

    override suspend fun Login(username: String, password: String): String {

        val jsonObject = JsonObject().apply {
            addProperty("email", username)
            addProperty("password", password)
        }

        val result = apiservice.Login(jsonObject)
        if (result.success) {
            TokenInMemory.refreshToken(username, result.access,result.refresh)
            saveToken(result.access)

            saveUserName(username)
            saveToken(result.access)
            saveRefresh(result.refresh)

            return VALUE_SUCCESS
        } else {
            return result.mesage
        }

    }

    override fun singout() {
        TokenInMemory.refreshToken(null,null,null)
        sharedPref.edit().clear().apply()
    }

    override fun loadToken() {
        TokenInMemory.refreshToken(getUserName(), getToken(),getRefresh())
    }

    override fun saveToken(newToken: String) {
        sharedPref.edit().putString("access", newToken).apply()
    }

    override fun getToken(): String? {
        return sharedPref.getString("access", "")

    }

    override fun saveUserName(username: String) {
        sharedPref.edit().putString("username", username).apply()
    }

    override fun getUserName(): String? {
        return sharedPref.getString("username", "")

    }

    override fun getRefresh(): String {
        return sharedPref.getString("refresh","")!!
    }

    override fun saveRefresh(refresh: String?) {
        sharedPref.edit().putString("refresh",refresh).apply()
    }
}