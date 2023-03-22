package com.example.startup_music_player.ui.features.verify

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.DialogFragment
import com.example.startup_music_player.R
import com.example.startup_music_player.databinding.DialogVerifyBinding
import com.example.startup_music_player.databinding.DialogVerifyRejectBinding

class VerifyRejectedDialogFragment : DialogFragment() {
    lateinit var binding:DialogVerifyRejectBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = DialogVerifyRejectBinding.inflate(layoutInflater , container , false)
        binding.lottieAnimationView.playAnimation()
        binding.btnAccept.setOnClickListener {
            dismiss()
        }
        return binding.root
    }

    override fun getTheme() = R.style.RoundedCornersDialog2


}