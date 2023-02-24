package com.example.startup_music_player.ui.features.DetailPlaylist

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.startup_music_player.R
import com.example.startup_music_player.databinding.FragmentDetailPlaylistBinding
import com.example.startup_music_player.ui.features.Logout.DialogLogout
import com.google.android.material.bottomsheet.BottomSheetDialogFragment

class detailPlaylistFragment : BottomSheetDialogFragment() {

    lateinit var binding:FragmentDetailPlaylistBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentDetailPlaylistBinding.inflate(layoutInflater , container , false)

        return binding.root

    }
    override fun getTheme() = R.style.RoundedCornersBottomSheetDialog

}