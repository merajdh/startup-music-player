package com.example.startup_music_player.ui.features.Register

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.util.Patterns
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.content.ContextCompat
import com.example.startup_music_player.R
import com.example.startup_music_player.databinding.FragmentRegisterBinding
import com.example.startup_music_player.model.repository.UserReposiroty
import com.example.startup_music_player.ui.features.Login.LoginFragment
import com.example.startup_music_player.ui.features.Main.MainFragment
import com.google.android.material.snackbar.Snackbar
import ir.dunijet.dunibazaar.util.VALUE_SUCCESS
import org.koin.android.ext.android.get
import org.koin.androidx.viewmodel.ext.android.viewModel


class RegisterFragment : Fragment() {
    lateinit var binding : FragmentRegisterBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        binding = FragmentRegisterBinding.inflate(layoutInflater,container,false)
        binding.btnRegister.setOnClickListener { IschektRegister() } //onclick_btnRegister
        binding.txtRegister.setOnClickListener {
            transform(LoginFragment())
        } // intent to Fragment Login
        return binding.root
    }

    private fun IschektRegister() {
        val viewmodel : RegisterViewModel by viewModel()
        if (binding.EdtUser.text.isNotEmpty() && binding.EdtGmail.text.isNotEmpty() && binding.EdtPassword.text.isNotEmpty() && binding.EdtPasswordRepeat.text.isNotEmpty()) {
            if (binding.EdtPassword.text.toString() == binding.EdtPasswordRepeat.text.toString()) {
                if (binding.EdtPassword.text.length >= 8) {
                    if (Patterns.EMAIL_ADDRESS.matcher(binding.EdtGmail.text).matches()){

                        // Input user
                        viewmodel.name.value = binding.EdtUser.text.toString()
                        viewmodel.email.value= binding.EdtGmail.text.toString()
                        viewmodel.password.value = binding.EdtPassword.text.toString()
                        viewmodel.confirmPassword.value = binding.EdtPasswordRepeat.text.toString()

                        // ischekt Answer server
                        viewmodel.signUpUser {
                            if (it == VALUE_SUCCESS){
                                transform(MainFragment())
                            }else{
                                Toast.makeText(context, it, Toast.LENGTH_SHORT).show()
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
    private fun transform(fragment : Fragment){
        val transform = parentFragmentManager.beginTransaction()
        transform.replace(R.id.FrameLayoutMain,fragment)
        transform.commit()
    } // transform
    private fun SnackbarError(text: String) {
        Snackbar
            .make(binding.root, text, Snackbar.LENGTH_LONG)
            .setBackgroundTint(ContextCompat.getColor(binding.root.context, R.color.light_blue))
            .setTextColor(ContextCompat.getColor(binding.root.context, R.color.white))
            .show()
    } // SnakBar
}