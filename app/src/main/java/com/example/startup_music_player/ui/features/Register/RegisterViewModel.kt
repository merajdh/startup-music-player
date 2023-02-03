package com.example.startup_music_player.ui.features.Register

import android.util.Log
import android.widget.Toast
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.startup_music_player.model.repository.UserReposiroty
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlin.math.log

class RegisterViewModel(private val userReposiroty: UserReposiroty) : ViewModel() {
    // Input User
    val name = MutableLiveData("")
    val email = MutableLiveData("")
    val password = MutableLiveData("")
    val confirmPassword = MutableLiveData("")

    fun signUpUser(LoggingEvent: (String) -> Unit) {
        val coroutineExceptionHandler = CoroutineExceptionHandler { _, throwable ->
            Log.v("error", "Error -> " + throwable.message)
        }
        viewModelScope.launch(coroutineExceptionHandler) {
            val result = userReposiroty.Register(name.value!!, email.value!!, password.value!!) // Answer server
            LoggingEvent(result) // Event Login to FragmentLogin
        }

    }
}