package com.example.startup_music_player.ui.features.Myplaylist

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.startup_music_player.R
import com.example.startup_music_player.databinding.FragmentMyplaylistBinding


class MyplaylistFragment : Fragment() {
    lateinit var binding : FragmentMyplaylistBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        binding = FragmentMyplaylistBinding.inflate(layoutInflater, container, false)

        binding.btnBack.setOnClickListener {

        }
        return binding.root
    }
}