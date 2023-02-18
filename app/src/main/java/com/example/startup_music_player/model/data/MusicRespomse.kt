package com.example.startup_music_player.model.data

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class MusicRespomse(
    val name : String,
    val time : String,
    val Cover :Boolean,
    val nemeArtist : String,
) : Parcelable