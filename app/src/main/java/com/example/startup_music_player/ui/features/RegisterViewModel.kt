package com.example.startup_music_player.ui.features

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.startup_music_player.model.repository.UserReposiroty

class RegisterViewModel(private val userReposiroty: UserReposiroty): ViewModel() {
    val username = MutableLiveData("")
    val gmaile = MutableLiveData("")
    val password = MutableLiveData("")


    fun RegisterUser(){

    }
}