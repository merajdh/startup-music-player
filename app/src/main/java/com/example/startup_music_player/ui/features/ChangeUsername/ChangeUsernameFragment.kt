package com.example.startup_music_player.ui.features.ChangeUsername

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.DialogFragment
import com.example.startup_music_player.R
import com.example.startup_music_player.databinding.DialogChangeUsernameBinding

class ChangeUsernameFragment : DialogFragment() {
    lateinit var binding: DialogChangeUsernameBinding
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = DialogChangeUsernameBinding.inflate(layoutInflater , container , false)
        setOnClickListeners()
        return binding.root
    }

    override fun getTheme() = R.style.RoundedCornersDialog2

    private fun setOnClickListeners(){
        binding.btnCancel.setOnClickListener { dismiss() }

        binding.btnAccept.setOnClickListener {

        }

    }
}