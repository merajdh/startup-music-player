package com.example.startup_music_player.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.startup_music_player.databinding.ActivityLoginBinding

class LoginActivity : AppCompatActivity() {
    lateinit var binding: ActivityLoginBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.animLogin.playAnimation()
        binding.txtRegister.setOnClickListener {
            val intent = Intent(this, RegisterActivity::class.java)
            startActivity(intent)
        }
        binding.btnLogin.setOnClickListener { IschektLogin() }

    }

    private fun IschektLogin() {
        // Chekt isNotEmpty  EDT
        if (binding.EdtUserLogin.text.isNotEmpty() &&
            binding.EdtPasswordLogin.text.isNotEmpty()
        ){
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        } else {

        }
    }
}