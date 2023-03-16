package com.example.startup_music_player.ui.features.verify

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.DialogFragment
import com.example.startup_music_player.R
import com.example.startup_music_player.databinding.DialogVerifyBinding

class VerifyDialogFragment : DialogFragment() {
    lateinit var binding:DialogVerifyBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = DialogVerifyBinding.inflate(layoutInflater , container , false)
        binding.lottieAnimationView.playAnimation()
        binding.btnAccept.setOnClickListener {
            dismiss()
        }
        return binding.root
    }

    override fun getTheme() = R.style.RoundedCornersDialog2


}