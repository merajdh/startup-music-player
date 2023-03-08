package com.example.startup_music_player.ui.features.Play

import android.graphics.RenderEffect
import android.graphics.Shader
import android.os.Build
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.startup_music_player.databinding.FragmentPlayBinding
import com.example.startup_music_player.ui.features.playDetail.playDetailFragment

class PlayFragment : Fragment() {
    lateinit var binding: FragmentPlayBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        binding = FragmentPlayBinding.inflate(layoutInflater, container, false)
        setBlur()
        setOnClickListeners()
        return binding.root

    }


    private fun setBlur(){
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.S) {
            binding.imgBackground.setRenderEffect(RenderEffect.createBlurEffect(30f, 30f , Shader.TileMode.MIRROR))
        }
    }

    private fun setOnClickListeners() {

        binding.btnOpenMore.setOnClickListener {
            val transform = playDetailFragment()
            transform.isCancelable = true
            transform.show(parentFragmentManager, null)
        }

    }

}