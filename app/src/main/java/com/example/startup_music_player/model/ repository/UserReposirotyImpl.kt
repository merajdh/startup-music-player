package com.example.startup_music_player.model.repository

class UserReposirotyImpl: UserReposiroty {

    override suspend fun Login(username: String, password: String) {

    }

    override suspend fun Register(username: String, gmail: String, password: String) {

    }

    override fun singout() {

    }

    override fun loadtoken() {

    }

    override fun saveToken(newToken: String) {

    }

    override fun getToken() : String {
        return ""
    }

    override fun saveusername(username: String) {

    }

    override fun getusername(): String {
        return ""
    }
}