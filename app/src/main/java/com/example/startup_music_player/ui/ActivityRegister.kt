package com.example.startup_music_player.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.content.ContextCompat
import androidx.core.view.isVisible
import com.example.startup_music_player.R
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
            binding.EdtPassword.text.isNotEmpty() &&
            binding.EdtPasswordRepeat.text.isNotEmpty()) {

        }else if (binding.EdtUser.text.isEmpty() or
            binding.EdtGmail.text.isEmpty() or
            binding.EdtPassword.text.isEmpty() or
            binding.EdtPasswordRepeat.text.isEmpty()){
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