package com.example.startup_music_player.ui.features.Register
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Patterns
import android.widget.Toast
import androidx.core.content.ContextCompat
import com.example.startup_music_player.R
import com.example.startup_music_player.databinding.ActivityRegisterBinding
import com.example.startup_music_player.model.repository.UserReposiroty
import com.example.startup_music_player.ui.features.Login.LoginActivity
import com.google.android.material.snackbar.Snackbar
import ir.dunijet.dunibazaar.util.VALUE_SUCCESS
import org.koin.android.ext.android.get
import org.koin.androidx.viewmodel.ext.android.viewModel

class RegisterActivity : AppCompatActivity() {
    lateinit var binding: ActivityRegisterBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRegisterBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val userReposiroty: UserReposiroty = get()
        userReposiroty.loadtoken()
        binding.btnRegister.setOnClickListener { IschektRegister() } //onclick_btnRegister
        binding.txtRegister.setOnClickListener {
            val intent = Intent(this, LoginActivity::class.java)
            startActivity(intent)
        } // intent to Activity Login
    }

    private fun IschektRegister() {
        val viewmodel : RegisterViewModel by viewModel()
        if (binding.EdtUser.text.isNotEmpty() && binding.EdtGmail.text.isNotEmpty() && binding.EdtPassword.text.isNotEmpty() && binding.EdtPasswordRepeat.text.isNotEmpty()) {
            if (binding.EdtPassword.text.toString() == binding.EdtPasswordRepeat.text.toString()) {
                if (binding.EdtPassword.text.length >= 8) {
                    if (Patterns.EMAIL_ADDRESS.matcher(binding.EdtGmail.text).matches()){
                        viewmodel.name.value = binding.EdtUser.text.toString()
                        viewmodel.email.value= binding.EdtGmail.text.toString()
                        viewmodel.password.value = binding.EdtPassword.text.toString()
                        viewmodel.confirmPassword.value = binding.EdtPasswordRepeat.text.toString()
                        viewmodel.signUpUser {
                            if (it == VALUE_SUCCESS){

                            }else{
                                Toast.makeText(this, it, Toast.LENGTH_SHORT).show()
                            }
                        }

                    }else{
                        // فرمت ایمل اشتباه است

                    }
                } else {
                    //snakbar -> کمتر از 8 تا password

                }
            } else {
                // snakbar -> یکی نبودن پسورد

            }
        } else {
            // snakbar -> پر کردن مقادیر

        }
    }

    private fun SnackbarError(text: String) {
        Snackbar
            .make(binding.root, text, Snackbar.LENGTH_LONG)
            .setBackgroundTint(ContextCompat.getColor(this, R.color.light_blue))
            .setTextColor(ContextCompat.getColor(this, R.color.white))
            .show()
    } // SnakBar
}

