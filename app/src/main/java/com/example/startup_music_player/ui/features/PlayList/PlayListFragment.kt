package com.example.startup_music_player.ui.features.PlayList

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.startup_music_player.R
import com.example.startup_music_player.databinding.FragmentPlaylistBinding
import com.example.startup_music_player.ui.Fragment.ProfileFragment

class PlayListFragment  : Fragment(){

    lateinit var binding: FragmentPlaylistBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        binding = FragmentPlaylistBinding.inflate(layoutInflater, container, false)

        return binding.root
    }


    override fun onDestroy() {
        super.onDestroy()
        val transform = parentFragmentManager.beginTransaction()
        transform.replace(R.id.FrameLayout, ProfileFragment())
        transform.commit()
    }
}