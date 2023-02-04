package com.example.startup_music_player.ui.features.Home

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.lifecycle.lifecycleScope
import com.denzcoskun.imageslider.constants.ScaleTypes
import com.denzcoskun.imageslider.models.SlideModel
import com.example.startup_music_player.databinding.FragmentHomeBinding
import com.example.startup_music_player.model.Contract.ContractHome
import com.example.startup_music_player.model.data.MusicRespomse
import com.example.startup_music_player.model.net.Apiservice
import com.example.startup_music_player.model.net.createApiService
import com.example.startup_music_player.model.presenter.PresenterHome
import com.google.android.material.transition.MaterialContainerTransform
import retrofit2.Retrofit
import retrofit2.create


class HomeFragment : Fragment() , ContractHome.View {
    lateinit var binding: FragmentHomeBinding
    lateinit var presenter: ContractHome.Presenter
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        binding = FragmentHomeBinding.inflate(layoutInflater,container,false)
        AddsliderCod() // slider
        presenter = PresenterHome(createApiService())
         lifecycleScope.launchWhenCreated {
             presenter.OnAttach(this@HomeFragment)
         }

        return binding.root
    }

  fun AddsliderCod() {
        val ItemSlider = ArrayList<SlideModel>()
        ItemSlider.add(SlideModel("https://images.hdqwalls.com/download/eminem-rapper-wallpaper-2560x1440.jpg"   , ScaleTypes.FIT))
        ItemSlider.add(SlideModel("https://images4.alphacoders.com/193/193108.jpg"   ,ScaleTypes.FIT))
        ItemSlider.add(SlideModel("https://wallpaper.dog/large/17006205.jpg" , ScaleTypes.FIT))
        binding.mouduleOneHome.slider.setImageList(ItemSlider)

    }

    override fun ShowPartiMusik(data: List<MusicRespomse>) {

    }

    override fun ShowTopMusik(data: String) {

        Log.v("TAgw",data)
    }

    override fun ShowTopViewMusik(data: List<MusicRespomse>) {

    }

    override fun ShowGuropMusik(data: List<MusicRespomse>) {
    }
}