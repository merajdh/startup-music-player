package com.example.startup_music_player.model.data

data class LoginRespomse(
    val expiresAt : Int,
    val message : String,
    val success :Boolean,
    val access : String,
    val refresh : String,
    val code : Int,
    val user_id : Int,
    val status : Boolean,

)