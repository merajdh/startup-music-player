package com.example.startup_music_player.ui.features.changePassword

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.DialogFragment
import com.example.startup_music_player.R
import com.example.startup_music_player.databinding.DialogChangePasswordBinding
import com.example.startup_music_player.ui.features.Main.MainFragment
import com.example.startup_music_player.ui.features.Profile.ProfileViewModel
import com.example.startup_music_player.ui.features.Register.RegisterFragment
import ir.dunijet.dunibazaar.util.VALUE_SUCCESS
import org.koin.androidx.viewmodel.ext.android.viewModel

@SuppressLint("StaticFieldLeak")
lateinit var binding : DialogChangePasswordBinding
class fragmentDialog : DialogFragment() {
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View
    {
        binding = DialogChangePasswordBinding.inflate(layoutInflater , container , false)
        isCancelable = true
        binding.updatePassword.setOnClickListener {
            if (binding.newePass.text == binding.repetitionpass.text){
                update()
            }else{
                // Show toast or dialog and ...
            }
        }
        return binding.root
    }
    fun update(){
        val viewmodel : ProfileViewModel by viewModel()
        viewmodel.old_password.value = binding.OldPass.text.toString()
        viewmodel.new_password.value = binding.newePass.text.toString()
        viewmodel.updatePassword {

            if (it == VALUE_SUCCESS){
                //dismiss this fragmentDialog


                // show dialog

            }else{
                Toast.makeText(context, it, Toast.LENGTH_SHORT).show()
            }
        }
    }
    override fun getTheme() = R.style.RoundedCornersDialog2



}