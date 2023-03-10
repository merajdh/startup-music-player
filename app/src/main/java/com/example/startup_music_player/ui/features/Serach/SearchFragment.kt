package com.example.startup_music_player.ui.features.Serach

import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.widget.addTextChangedListener
import androidx.fragment.app.Fragment
import com.example.startup_music_player.R
import com.example.startup_music_player.databinding.FragmentSearchBinding


class SearchFragment : Fragment() {

    lateinit var binding: FragmentSearchBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentSearchBinding.inflate(layoutInflater, container, false)
        setOnClickListeners()
        binding.EdtSearch.addTextChangedListener {
            search()

        }
        return inflater.inflate(R.layout.fragment_search, container, false)
    }

    private fun search() {

    }

    private fun setOnClickListeners() {

        binding.swipeSearch.setOnRefreshListener {
            // load data hare

            Handler(Looper.getMainLooper()).postDelayed({
                binding.swipeSearch.isRefreshing = false

            }, 800)
        }
    }

}
