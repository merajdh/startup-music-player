package com.example.startup_music_player.ui.features.changePassword

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.DialogFragment
import com.example.startup_music_player.R
import com.example.startup_music_player.databinding.DialogPaswordChangedBinding

class PasswordIsChangedDialog : DialogFragment() {
    lateinit var binding: DialogPaswordChangedBinding
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DialogPaswordChangedBinding.inflate(layoutInflater , container , false)

        binding.btnAccept.setOnClickListener {
            dismiss()
        }
        binding.lottieAnimationView.playAnimation()
        return binding.root
    }
    override fun getTheme() = R.style.RoundedCornersDialog2

}