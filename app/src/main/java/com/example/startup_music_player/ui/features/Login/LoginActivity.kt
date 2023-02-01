package com.example.startup_music_player.ui.features.Login

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.startup_music_player.databinding.ActivityLoginBinding
import com.example.startup_music_player.ui.features.Register.RegisterActivity

class LoginActivity : AppCompatActivity() {
    lateinit var binding: ActivityLoginBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)
//        val userReposiroty : UserReposiroty = get()
//        userReposiroty.loadtoken()
        binding.animLogin.playAnimation() // Ply Anim lotti
        binding.txtRegister.setOnClickListener {
            val intent = Intent(this, RegisterActivity::class.java)
            startActivity(intent)
        } // intent to Activity Register
        binding.btnLogin.setOnClickListener { IschektLogin() } //intent to Activity home

    }

    private fun IschektLogin() {
        if (binding.EdtUserLogin.text.isNotEmpty() && binding.EdtPasswordLogin.text.isNotEmpty()) {

        } else {
            // scakbar
        }
    }
}
