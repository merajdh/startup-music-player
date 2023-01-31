package com.example.startup_music_player.ui.Activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import com.example.startup_music_player.databinding.ActivityLoginBinding
import com.example.startup_music_player.model.repository.UserReposiroty
import com.example.startup_music_player.ui.features.LoginViewModel
import ir.dunijet.dunibazaar.util.VALUE_SUCCESS
import org.koin.android.ext.android.get

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
        val viewmodel = ViewModelProvider(this).get(LoginViewModel::class.java)
        // Chekt isNotEmpty  EDT
        if (binding.EdtUserLogin.text.isNotEmpty() &&
            binding.EdtPasswordLogin.text.isNotEmpty()
        ){
            viewmodel.LoginUser {
                if (it== VALUE_SUCCESS){
                    val intent = Intent(this, MainActivity::class.java)
                    startActivity(intent)

                }else{
                    // Snakbar
                }
            }
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        } else {

        }
    }
}