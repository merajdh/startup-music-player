package com.example.startup_music_player.model.data

data class LoginRespomse(
    val expiresAt : Int,
    val mesage : String,
    val success :Boolean,
    val token : String,
)