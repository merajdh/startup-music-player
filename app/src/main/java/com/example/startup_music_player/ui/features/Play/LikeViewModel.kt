package com.example.startup_music_player.ui.features.Play

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.startup_music_player.model.repository.Like.LikeRepository
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.launch

class LikeViewModel(private val likeRepository: LikeRepository) : ViewModel() {
    val pk = MutableLiveData("")

    fun LikeMusic(sendmusik: (String) -> Unit) {
        val coroutineExceptionHandler = CoroutineExceptionHandler { _, throwable ->
            Log.v("error", "Error -> " + throwable.message)

        } // view error

        viewModelScope.launch(coroutineExceptionHandler) {
            val result =  likeRepository.AddLike(pk.value!!) // Answer server
            sendmusik(result) // Event Login to FragmentLogin

        }
    }
}