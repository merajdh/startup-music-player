package com.example.startup_music_player.ui.features.LikedMusic

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.startup_music_player.databinding.FragmentLikedMusicBinding

lateinit var binding: FragmentLikedMusicBinding
class LikedMusicFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentLikedMusicBinding.inflate(layoutInflater , container , false)
        
        return binding.root
    }
}