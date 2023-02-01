package com.example.startup_music_player.ui.Fragment

import android.app.AlertDialog
import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.DialogFragment
import com.example.startup_music_player.R
import com.example.startup_music_player.databinding.FragmentHomeBinding
import com.example.startup_music_player.databinding.FragmentProfileBinding
import kotlinx.coroutines.flow.combine

class ProfileFragment : Fragment() {
    lateinit var binding: FragmentProfileBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentProfileBinding.inflate(layoutInflater , container , false)

        settOnClickListeners()
        return binding.root
    }

    fun settOnClickListeners () {
        // moudule two setOnClickListener ->
        binding.mouduleTwo.btnChangePassword.setOnClickListener {
            val mainDialog = fragmentDialog()
            mainDialog.show(parentFragmentManager , null)
        }

        // moudule three setOnClickListener ->
        binding.mouduleThree.btnComment.setOnClickListener {
        }

        binding.mouduleThree.btnAbout.setOnClickListener {
        }

        binding.mouduleThree.btnLogOut.setOnClickListener {
        }
    }

}