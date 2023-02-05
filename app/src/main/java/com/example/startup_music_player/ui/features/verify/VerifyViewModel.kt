package com.example.startup_music_player.ui.features.verify

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.startup_music_player.model.repository.UserReposiroty
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.launch

class VerifyViewModel(private val userReposiroty: UserReposiroty): ViewModel() {
    // Input User
    val Code = MutableLiveData("")

    fun VerifyEmail(VerifyEvent: (String) -> Unit){
        val coroutineExceptionHandler = CoroutineExceptionHandler { _, throwable ->
            Log.v("error", "Error -> " + throwable.message)

        } // view error
        viewModelScope.launch(coroutineExceptionHandler) {
            val result =  userReposiroty.Verify(Code.value!!) // Answer server
            VerifyEvent(result) // Event Login to FragmentLogin

        }
    }
}