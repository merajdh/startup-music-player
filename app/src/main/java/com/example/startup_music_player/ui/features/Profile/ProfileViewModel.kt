package com.example.startup_music_player.ui.features.Profile

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.startup_music_player.model.repository.UserReposiroty
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.launch

class ProfileViewModel(private val userReposiroty: UserReposiroty) :ViewModel() {
    val old_password = MutableLiveData("")
    val new_password = MutableLiveData("")

    fun singout(){
        userReposiroty.singout()
    }

    fun updatePassword(UpdateEvent: (String) -> Unit){
        val coroutineExceptionHandler = CoroutineExceptionHandler { _, throwable ->
            Log.v("error", "Error -> " + throwable.message)
        } // view error
        viewModelScope.launch(coroutineExceptionHandler) {
            val result =  userReposiroty.updatepassword(old_password.value!!, new_password.value!!) // Answer server
            UpdateEvent(result)

        }
    }

}