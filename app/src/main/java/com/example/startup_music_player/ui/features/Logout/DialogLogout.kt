package com.example.startup_music_player.ui.features.Logout

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.DialogFragment
import com.example.startup_music_player.R
import com.example.startup_music_player.databinding.DiaogLogoutBinding

lateinit var binding: DiaogLogoutBinding

    class DialogLogout : DialogFragment() {
        override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
           binding = DiaogLogoutBinding.inflate(layoutInflater , container , false)
            isCancelable = true
            binding.btnCancel.setOnClickListener {
                dismiss()
            }
            return binding.root
        }

        override fun getTheme() = R.style.RoundedCornersDialog2

    }
