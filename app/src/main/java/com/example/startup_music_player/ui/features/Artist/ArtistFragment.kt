package com.example.startup_music_player.ui.features.Artist

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.activity.OnBackPressedCallback
import androidx.activity.addCallback
import androidx.fragment.app.Fragment
import com.example.startup_music_player.R
import com.example.startup_music_player.databinding.FragmentArtistProfileBinding
import com.example.startup_music_player.ui.Fragment.ProfileFragment
import com.example.startup_music_player.ui.features.Home.HomeFragment

class ArtistFragment : Fragment() {


    lateinit var binding : FragmentArtistProfileBinding
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentArtistProfileBinding.inflate(layoutInflater, container, false)
        setOnClickListener()
        return binding.root

    }
    private fun setOnClickListener(){
//        moudule One ->

        binding.mouduleOneArtist.btnBack.setOnClickListener {
            parentFragmentManager.popBackStack()
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        val transform = parentFragmentManager.beginTransaction()
        transform.addToBackStack(null)
        transform.replace(R.id.FrameLayout, HomeFragment())
        transform.commit()
    }

}