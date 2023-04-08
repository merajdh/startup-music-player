package com.example.startup_music_player.ui.features.Profile

import androidx.lifecycle.ViewModel
import com.example.startup_music_player.model.repository.UserReposiroty

class ProfileViewModel(private val userReposiroty: UserReposiroty) :ViewModel() {


    fun singout(){
        userReposiroty.singout()
    }
}