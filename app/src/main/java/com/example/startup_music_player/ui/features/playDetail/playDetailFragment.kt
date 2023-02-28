package com.example.startup_music_player.ui.features.playDetail

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.startup_music_player.R
import com.example.startup_music_player.databinding.FragmentContactUsBinding
import com.example.startup_music_player.databinding.FragmentDetailPlaylistBinding
import com.example.startup_music_player.databinding.FragmetnDetailPlayBinding
import com.google.android.material.bottomsheet.BottomSheetBehavior
import com.google.android.material.bottomsheet.BottomSheetDialogFragment

class playDetailFragment : BottomSheetDialogFragment() {


    lateinit var binding: FragmetnDetailPlayBinding
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding  = FragmetnDetailPlayBinding.inflate(layoutInflater , container , false)

        BottomSheetBehavior.STATE_COLLAPSED
        return binding.root
    }

    override fun getTheme() = R.style.RoundedCornersBottomSheetDialog


}