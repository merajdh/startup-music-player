package com.example.startup_music_player.ui.features

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.startup_music_player.model.repository.UserReposiroty
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class RegisterViewModel(private val userReposiroty: UserReposiroty) : ViewModel() {
    val username = MutableLiveData("")
    val gmaile = MutableLiveData("")
    val password = MutableLiveData("")


    fun RegisterUser(LoggingEvent: (String) -> Unit) {
        viewModelScope.launch() {
          val result =   userReposiroty.Register(username.value!!, gmaile.value!!, password.value!!)
            LoggingEvent(result)
        }

    }
}