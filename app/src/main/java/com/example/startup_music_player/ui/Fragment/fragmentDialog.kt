package com.example.startup_music_player.ui.Fragment

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.DialogFragment
import com.example.startup_music_player.R
import com.example.startup_music_player.databinding.FragmentDialogChangeBinding

@SuppressLint("StaticFieldLeak")
lateinit var binding : FragmentDialogChangeBinding
class fragmentDialog : DialogFragment() {
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = FragmentDialogChangeBinding.inflate(layoutInflater , container , false)
        return binding.root
    }
    override fun getTheme() = R.style.RoundedCornersDialog



}