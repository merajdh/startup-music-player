package com.example.startup_music_player.ui.features.Play

import android.graphics.RenderEffect
import android.graphics.Shader
import android.os.Build
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.example.startup_music_player.databinding.FragmentPlayBinding
import com.example.startup_music_player.ui.features.playDetail.playDetailFragment
import jp.wasabeef.glide.transformations.BlurTransformation

class PlayFragment : Fragment() {
    lateinit var binding: FragmentPlayBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        binding = FragmentPlayBinding.inflate(layoutInflater, container, false)
        blurImage()
        setOnClickListeners()
        return binding.root

    }


    private fun blurImage() {
        Glide.with(this).load(binding.imgBackground.drawable)
            .apply(RequestOptions.bitmapTransform(BlurTransformation(8, 1)))
            .into(binding.imgBackground)        }

    private fun setOnClickListeners() {

        binding.btnOpenMore.setOnClickListener {
            val transform = playDetailFragment()
            transform.isCancelable = true
            transform.show(parentFragmentManager, null)
        }


    }

}