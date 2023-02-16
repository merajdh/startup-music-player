package com.example.startup_music_player.ui.features.intro

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.AlphaAnimation
import androidx.fragment.app.Fragment
import com.example.startup_music_player.R
import com.example.startup_music_player.databinding.FragmentIntroBinding
import com.example.startup_music_player.ui.MainActivity
import com.example.startup_music_player.ui.features.Home.HomeFragment
import com.example.startup_music_player.ui.features.Main.MainFragment
import java.util.*
import kotlin.concurrent.schedule

class IntroFragment : Fragment() {
    lateinit var binding: FragmentIntroBinding
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentIntroBinding.inflate(layoutInflater , container , false)
        animation ()
        return binding.root
    }

    fun animation (){
        val anim = AlphaAnimation(0f , 1f)
        anim.duration = 2000L
        binding.animIntro.playAnimation()
        binding.txtAppName.startAnimation(anim)
        binding.txtVersion.startAnimation(anim)
        binding.animIntro.startAnimation(anim)


    }

}