package com.example.startup_music_player.ui.features

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.startup_music_player.model.repository.UserReposiroty

class LoginViewModel(private val userReposiroty: UserReposiroty): ViewModel() {
    val username = MutableLiveData("")
    val password = MutableLiveData("")

    fun LoginUser(){

    }
}