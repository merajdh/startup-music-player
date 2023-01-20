package com.example.startup_music_player.ui.Fragment

import android.R
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.denzcoskun.imageslider.models.SlideModel
import com.example.startup_music_player.databinding.FragmentHomeBinding
import com.github.furkankaplan.fkblurview.FKBlurView


class HomeFragment : Fragment() {
    lateinit var binding: FragmentHomeBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentHomeBinding.inflate(layoutInflater,container,false)
        AddsliderCod() // slider

        return binding.root
    }

    private fun AddsliderCod() {
        val ItemSlider = ArrayList<SlideModel>()
        ItemSlider.add(SlideModel("https://images.hdqwalls.com/download/eminem-rapper-wallpaper-2560x1440.jpg"))
        ItemSlider.add(SlideModel("https://images4.alphacoders.com/193/193108.jpg"))
        ItemSlider.add(SlideModel("https://wallpaper.dog/large/17006205.jpg"))
        binding.mouduleOneHome.slider.setImageList(ItemSlider)

    }
}