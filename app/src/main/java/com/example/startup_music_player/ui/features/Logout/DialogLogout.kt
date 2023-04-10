package com.example.startup_music_player.ui.features.Logout

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.DialogFragment
import androidx.fragment.app.Fragment
import com.example.startup_music_player.R
import com.example.startup_music_player.databinding.DiaogLogoutBinding
import com.example.startup_music_player.ui.features.Profile.ProfileViewModel
import com.example.startup_music_player.ui.features.Register.RegisterFragment
import org.koin.androidx.viewmodel.ext.android.viewModel

lateinit var binding: DiaogLogoutBinding

    class DialogLogout : DialogFragment() {
        override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
           binding = DiaogLogoutBinding.inflate(layoutInflater , container , false)
            isCancelable = true
            binding.btnAccept.setOnClickListener { Loguot() }
            binding.btnCancel.setOnClickListener { dismiss() }
            return binding.root
        }
        private fun Loguot() {
            val viewmodel : ProfileViewModel by viewModel()
            viewmodel.singout()
            transform(RegisterFragment())
        }
        override fun getTheme() = R.style.RoundedCornersDialog2

        private fun transform (fragment: Fragment) {
            val transform = parentFragmentManager.beginTransaction()
            transform.replace(R.id.FrameLayout, fragment)
            transform.commit()
        }
    }
