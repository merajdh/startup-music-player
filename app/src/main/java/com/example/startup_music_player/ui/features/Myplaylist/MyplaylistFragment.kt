package com.example.startup_music_player.ui.features.Myplaylist

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.startup_music_player.R
import com.example.startup_music_player.databinding.FragmentMyplaylistBinding
import com.example.startup_music_player.ui.Fragment.ProfileFragment

@SuppressLint("StaticFieldLeak")
lateinit var binding: FragmentMyplaylistBinding

class MyplaylistFragment : Fragment() {

    class MyplaylistFragment : Fragment() {
        lateinit var binding: FragmentMyplaylistBinding
        override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
        ): View {
            binding = FragmentMyplaylistBinding.inflate(layoutInflater, container, false)
            setOnClickListener()
            return binding.root
        }

        private fun setOnClickListener() {
            binding.btnBack.setOnClickListener {
                parentFragmentManager.popBackStack()
            }

        }

        override fun onDestroy() {
            super.onDestroy()
            val transform = parentFragmentManager.beginTransaction()
            transform.addToBackStack(null)
            transform.replace(R.id.FrameLayout, ProfileFragment())
            transform.commit()
        }

    }
}
