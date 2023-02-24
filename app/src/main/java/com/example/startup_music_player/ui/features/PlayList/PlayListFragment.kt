package com.example.startup_music_player.ui.features.PlayList

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.startup_music_player.databinding.FragmentPlaylistBinding

class PlayListFragment  : Fragment(){

    lateinit var binding: FragmentPlaylistBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        binding = FragmentPlaylistBinding.inflate(layoutInflater, container, false)

        return binding.root
    }
}