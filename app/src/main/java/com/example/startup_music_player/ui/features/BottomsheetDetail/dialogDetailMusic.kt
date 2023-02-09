package com.example.startup_music_player.ui.features.BottomsheetDetail

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.startup_music_player.R
import com.example.startup_music_player.databinding.FragmentDetailBinding
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
lateinit var binding: FragmentDetailBinding
class DetaiMusiclFragment : BottomSheetDialogFragment() {
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = FragmentDetailBinding.inflate(layoutInflater, container, false)
        setOnClickListeners()
        return binding.root
    }
    private fun setOnClickListeners(){
        //moudule Two ->
        binding.mouduleTwoDetail.btnAddToPlaylist.setOnClickListener {
        }

        binding.mouduleTwoDetail.btnAddToFavorite.setOnClickListener {
        }

        binding.mouduleTwoDetail.btnArtist.setOnClickListener {
        }

        binding.mouduleTwoDetail.btnShare.setOnClickListener {
        }
    }

    override fun getTheme() = R.style.RoundedCornersBottomSheetDialog
}