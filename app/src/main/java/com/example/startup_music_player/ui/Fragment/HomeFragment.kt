package com.example.startup_music_player.ui.Fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import com.denzcoskun.imageslider.constants.ScaleTypes
import com.denzcoskun.imageslider.models.SlideModel
import com.example.startup_music_player.databinding.FragmentHomeBinding
import com.google.android.material.transition.MaterialContainerTransform


class HomeFragment : Fragment() {
    lateinit var binding: FragmentHomeBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        binding = FragmentHomeBinding.inflate(layoutInflater,container,false)
        AddsliderCod() // slider
        return binding.root
    }

  fun AddsliderCod() {
        val ItemSlider = ArrayList<SlideModel>()
        ItemSlider.add(SlideModel("https://images.hdqwalls.com/download/eminem-rapper-wallpaper-2560x1440.jpg"   , ScaleTypes.FIT))
        ItemSlider.add(SlideModel("https://images4.alphacoders.com/193/193108.jpg"   ,ScaleTypes.FIT))
        ItemSlider.add(SlideModel("https://wallpaper.dog/large/17006205.jpg" , ScaleTypes.FIT))
        binding.mouduleOneHome.slider.setImageList(ItemSlider)

    }
}