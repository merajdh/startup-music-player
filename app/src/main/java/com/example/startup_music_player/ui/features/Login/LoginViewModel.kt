package com.example.startup_music_player.ui.features.Login

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.startup_music_player.model.repository.UserReposiroty
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.launch

class LoginViewModel(private val userReposiroty: UserReposiroty): ViewModel() {
    val username = MutableLiveData("")
    val password = MutableLiveData("")

    fun LoginUser(LoggingEvent: (String) -> Unit){
        val coroutineExceptionHandler = CoroutineExceptionHandler { _, throwable ->
            Log.v("error", "Error -> " + throwable.message)
        }
        viewModelScope.launch(coroutineExceptionHandler) {
            val result =  userReposiroty.Login(username.value!!, password.value!!)
            LoggingEvent(result)
        }
    }
}