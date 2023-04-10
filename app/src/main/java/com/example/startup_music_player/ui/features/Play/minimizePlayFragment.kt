package com.example.startup_music_player.ui.features.Play

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.startup_music_player.databinding.FragmentMinimizePlayBinding


class minimizePlayFragment : Fragment() {
    lateinit var binding:FragmentMinimizePlayBinding
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = FragmentMinimizePlayBinding.inflate(layoutInflater,container,false)


        return binding.root
    }
}