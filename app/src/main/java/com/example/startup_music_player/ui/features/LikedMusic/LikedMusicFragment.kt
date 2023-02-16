package com.example.startup_music_player.ui.features.LikedMusic

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.startup_music_player.R
import com.example.startup_music_player.databinding.FragmentLikedMusicBinding
import com.example.startup_music_player.ui.Fragment.ProfileFragment

lateinit var binding: FragmentLikedMusicBinding
class LikedMusicFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentLikedMusicBinding.inflate(layoutInflater , container , false)
        setOnClickListener()
        return binding.root
    }

    override fun onDestroy() {
        super.onDestroy()
        val transform = parentFragmentManager.beginTransaction()
        transform.addToBackStack(null)
        transform.replace(R.id.FrameLayout, ProfileFragment())
        transform.commit()
    }

    private fun setOnClickListener(){
        binding.btnBack.setOnClickListener {
            parentFragmentManager.popBackStack()
        }
    }

}