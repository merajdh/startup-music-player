package com.example.startup_music_player.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.startup_music_player.databinding.ActivityRegisterBinding

class ActivityRegister : AppCompatActivity() {
    lateinit var  binding: ActivityRegisterBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRegisterBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}