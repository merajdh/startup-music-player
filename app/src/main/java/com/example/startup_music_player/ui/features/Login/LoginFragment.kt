package com.example.startup_music_player.ui.features.Login


import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.example.startup_music_player.R
import com.example.startup_music_player.databinding.FragmentLoginBinding
import com.example.startup_music_player.ui.features.Main.MainFragment
import com.example.startup_music_player.ui.features.Register.RegisterFragment
import ir.dunijet.dunibazaar.util.VALUE_SUCCESS
import org.koin.androidx.viewmodel.ext.android.viewModel

class LoginFragment : Fragment() {
    lateinit var binding: FragmentLoginBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        binding = FragmentLoginBinding.inflate(layoutInflater,container,false)
        binding.animLogin.playAnimation() // Ply Anim lotti
        binding.txtRegister.setOnClickListener {
            transform(RegisterFragment())
        } // intent to Activity Register
        binding.btnLogin.setOnClickListener { IschektLogin() } //intent to Activity home
        return binding.root
    }

    private fun IschektLogin() {
        val viewmodel : LoginViewModel by viewModel()
        if (binding.EdtEmailLogin.text.isNotEmpty() && binding.EdtPasswordLogin.text.isNotEmpty()) {
            viewmodel.username.value = binding.EdtEmailLogin.text.toString()
            viewmodel.password.value = binding.EdtPasswordLogin.text.toString()
            viewmodel.LoginUser {
                if (it == VALUE_SUCCESS){
                    transform(MainFragment())
                }else{
                    Toast.makeText(context, it, Toast.LENGTH_SHORT).show()
                }
            }

        } else {
            // scakbar
        }
    }
    private fun transform(fragment : Fragment){
        val transform = parentFragmentManager.beginTransaction()
        transform.replace(R.id.FrameLayoutMain,fragment)
        transform.commit()
    } // transform
}