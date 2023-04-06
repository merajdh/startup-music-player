package com.example.startup_music_player.ui.features.changePassword

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.DialogFragment
import com.example.startup_music_player.R
import com.example.startup_music_player.databinding.DialogChangePasswordBinding

@SuppressLint("StaticFieldLeak")
lateinit var binding : DialogChangePasswordBinding
class fragmentDialog : DialogFragment() {
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = DialogChangePasswordBinding.inflate(layoutInflater , container , false)
        isCancelable = true
        return binding.root
    }
    override fun getTheme() = R.style.RoundedCornersDialog2



}