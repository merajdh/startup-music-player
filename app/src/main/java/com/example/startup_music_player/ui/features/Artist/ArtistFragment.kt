package com.example.startup_music_player.ui.features.Artist

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.startup_music_player.databinding.FragmentArtistProfileBinding

class ArtistFragment : Fragment() {

    lateinit var binding : FragmentArtistProfileBinding
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentArtistProfileBinding.inflate(layoutInflater , container , false)

        return binding.root
    }
}