package com.example.startup_music_player.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.content.ContextCompat
import androidx.core.view.isVisible
import com.example.startup_music_player.R
import com.example.startup_music_player.databinding.ActivityRegisterBinding
import com.google.android.material.snackbar.Snackbar

class RegisterActivity : AppCompatActivity() {
    lateinit var binding: ActivityRegisterBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRegisterBinding.inflate(layoutInflater)
        setContentView(binding.root)
<<<<<<< HEAD:app/src/main/java/com/example/startup_music_player/ui/ActivityRegister.kt
        binding.btnRegister.setOnClickListener { IschektRegister() }

=======
        binding.btnRegister.setOnClickListener { IschektRegister() } //onclick_btnRegister
>>>>>>> df555934e531118b9e5870a5319318cbddecc9ab:app/src/main/java/com/example/startup_music_player/ui/RegisterActivity.kt
    }

    private fun IschektRegister() {
        if (binding.EdtUser.text.isNotEmpty() &&
            binding.EdtGmail.text.isNotEmpty() &&
<<<<<<< HEAD:app/src/main/java/com/example/startup_music_player/ui/ActivityRegister.kt
            binding.EdtPassword.text.isNotEmpty() &&
            binding.EdtPasswordRepeat.text.isNotEmpty()) {

=======
            binding.EdtNumber.text.isNotEmpty() &&
            binding.EdtPassword.text.isNotEmpty()) {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
>>>>>>> df555934e531118b9e5870a5319318cbddecc9ab:app/src/main/java/com/example/startup_music_player/ui/RegisterActivity.kt
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