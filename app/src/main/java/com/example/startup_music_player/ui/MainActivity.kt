package com.example.startup_music_player.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.startup_music_player.R
import com.example.startup_music_player.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.animLogin.playAnimation()
        binding.txtRegister.setOnClickListener {
            val intent = Intent(this, ActivityRegister::class.java)
            startActivity(intent)
        }
        binding.btnLogin.setOnClickListener { IschektLogin() }

    }

    private fun IschektLogin() {
        // Chekt isNotEmpty  EDT
        if (binding.EdtUserLogin.text.isNotEmpty() &&
            binding.EdtPasswordLogin.text.isNotEmpty()
        ){
            val intent = Intent(this, ActivityHome::class.java)
            startActivity(intent)
        } else {

        }
    }
}