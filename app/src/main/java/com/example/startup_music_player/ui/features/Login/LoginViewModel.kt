package com.example.startup_music_player.ui.features.Login

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.startup_music_player.model.repository.user.UserReposiroty
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.launch

class LoginViewModel(private val userReposiroty: UserReposiroty): ViewModel() {
    // Input User
    val username = MutableLiveData("")
    val password = MutableLiveData("")

    fun LoginUser(LoggingEvent: (String) -> Unit){
        val coroutineExceptionHandler = CoroutineExceptionHandler { _, throwable ->
            Log.v("error", "Error -> " + throwable.message)
        } // view error
        viewModelScope.launch(coroutineExceptionHandler) {
            val result =  userReposiroty.Login(username.value!!, password.value!!) // Answer server
            LoggingEvent(result) // Event Login to FragmentLogin

        }
    }
}