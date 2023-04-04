package com.example.startup_music_player.ui.features.Myplaylist

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.DialogFragment
import com.example.startup_music_player.R
import com.example.startup_music_player.databinding.DialogAddPlaylistBinding

class AddPlaylistDialog : DialogFragment(){
    lateinit var binding:DialogAddPlaylistBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        binding = DialogAddPlaylistBinding.inflate(layoutInflater , container , false)
        return binding.root
    }

    override fun getTheme() = R.style.RoundedCornersDialog2

}