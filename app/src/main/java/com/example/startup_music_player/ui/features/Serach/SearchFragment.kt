package com.example.startup_music_player.ui.features.Serach

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.startup_music_player.R
import com.example.startup_music_player.databinding.FragmentSearchBinding


class SearchFragment : Fragment() {

    lateinit var binding:FragmentSearchBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentSearchBinding.inflate(layoutInflater , container , false)
        return inflater.inflate(R.layout.fragment_search, container, false)
    }

}