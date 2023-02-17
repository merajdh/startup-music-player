package com.example.startup_music_player.ui.features.intro

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.AlphaAnimation
import android.view.animation.Animation
import android.view.animation.RotateAnimation
import androidx.fragment.app.Fragment
import com.example.startup_music_player.R
import com.example.startup_music_player.databinding.FragmentIntroBinding
import com.example.startup_music_player.model.repository.TokenInMemory
import com.example.startup_music_player.ui.MainActivity
import com.example.startup_music_player.ui.features.Home.HomeFragment
import com.example.startup_music_player.ui.features.Main.MainFragment
import com.example.startup_music_player.ui.features.Register.RegisterFragment
import java.util.*
import kotlin.concurrent.schedule

class IntroFragment : Fragment() {
    lateinit var binding: FragmentIntroBinding
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentIntroBinding.inflate(layoutInflater , container , false)
        animation ()
        if (TokenInMemory.Token != null) {
            Timer().schedule(5000) {
                transform(MainFragment())
            }
        }else{
            transform(RegisterFragment())
        }
        return binding.root
    }

    fun animation (){
        val anim = AlphaAnimation(0f , 2f)
        anim.duration = 2000L
        anim.fillAfter = true

        val anim2 = RotateAnimation(0f , 360f , Animation.RELATIVE_TO_SELF, 0.5f , Animation.RELATIVE_TO_SELF, 0.5f)
        anim2.duration = 1000L
        anim2.fillAfter = true


        binding.animIntro.playAnimation()
        binding.txtAppName.startAnimation(anim)
        binding.txtVersion.startAnimation(anim)
        binding.animIntro.startAnimation(anim2)

    }
    private fun transform(fragment: Fragment) {
        val transform = parentFragmentManager.beginTransaction()
        transform.replace(R.id.FrameLayoutMain, fragment)
        transform.commit()
    }
}