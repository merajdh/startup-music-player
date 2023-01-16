package com.example.startup_music_player.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.startup_music_player.databinding.ActivityRegisterBinding
import com.google.android.material.snackbar.Snackbar

class ActivityRegister : AppCompatActivity() {
    lateinit var binding: ActivityRegisterBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRegisterBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.btnRegister.setOnClickListener { IschektRegister() }
    }

    private fun IschektRegister() {
        if (binding.EdtUser.text.isNotEmpty() &&
            binding.EdtGmail.text.isNotEmpty() &&
            binding.EdtNumber.text.isNotEmpty() &&
            binding.EdtPassword.text.isNotEmpty()) {

        }else{

        }
    }
}