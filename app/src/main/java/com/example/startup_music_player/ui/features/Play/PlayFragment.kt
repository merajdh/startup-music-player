package com.example.startup_music_player.ui.features.Play

import android.graphics.RenderEffect
import android.graphics.Shader
import android.os.Build
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.startup_music_player.R
import com.example.startup_music_player.databinding.FragmentPlayBinding

class PlayFragment : Fragment() {
    lateinit var binding: FragmentPlayBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        binding = FragmentPlayBinding.inflate(layoutInflater, container, false)

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.S) {
            binding.imgBackground.setRenderEffect(RenderEffect.createBlurEffect(30f, 30f , Shader.TileMode.MIRROR))
        }
        return binding.root

    }


}