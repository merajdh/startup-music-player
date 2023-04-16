package com.example.startup_music_player.ui.features.ContactUs

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.startup_music_player.R
import com.example.startup_music_player.databinding.FragmentContactUsDetailBinding
import com.google.android.material.bottomsheet.BottomSheetDialogFragment

class ContactUsDetailFragment : BottomSheetDialogFragment() {
    lateinit var binding:FragmentContactUsDetailBinding
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding  = FragmentContactUsDetailBinding.inflate(layoutInflater , container , false)
        setOnClickListeners()
        return binding.root
    }

    private fun setOnClickListeners(){
        binding.btnCancel.setOnClickListener { dismiss() }

        binding.btnAccept.setOnClickListener {

        }
    }

    override fun getTheme() = R.style.RoundedCornersBottomSheetDialog


}