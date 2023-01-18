package com.example.startup_music_player.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.core.content.ContextCompat
import com.example.startup_music_player.R
import com.example.startup_music_player.databinding.ActivityRegisterBinding
import com.google.android.material.snackbar.Snackbar

class RegisterActivity : AppCompatActivity() {
    lateinit var binding: ActivityRegisterBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRegisterBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.btnRegister.setOnClickListener { IschektRegister() } //onclick_btnRegister
    }

    private fun IschektRegister() {
        if (binding.EdtUser.text.isNotEmpty() &&
            binding.EdtGmail.text.isNotEmpty() &&
            binding.EdtNumber.text.isNotEmpty() &&
            binding.EdtPassword.text.isNotEmpty()) {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }else if (binding.EdtUser.text.isEmpty() or
            binding.EdtGmail.text.isEmpty() or
            binding.EdtNumber.text.isEmpty() or
            binding.EdtPassword.text.isEmpty()){
            SnackbarEmpty()
        }

    }
    fun SnackbarEmpty (){
        Snackbar
            .make(binding.root , "لطفا تمام فیلد ها را تکمیل کنید !" , Snackbar.LENGTH_LONG)
            .setBackgroundTint(ContextCompat.getColor(this , R.color.light_blue))
            .setTextColor(ContextCompat.getColor(this , R.color.white))
            .show()
    }

}