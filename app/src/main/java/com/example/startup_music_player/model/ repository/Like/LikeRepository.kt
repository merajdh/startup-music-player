package com.example.startup_music_player.model.repository.Like

interface LikeRepository {
    suspend fun AddLike(id: String): String
}