package com.example.startup_music_player.ui.features.Home

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout
import com.denzcoskun.imageslider.constants.ScaleTypes
import com.denzcoskun.imageslider.interfaces.ItemClickListener
import com.denzcoskun.imageslider.models.SlideModel
import com.example.startup_music_player.databinding.FragmentHomeBinding
import com.example.startup_music_player.model.Adapter.HomeAdapter
import com.example.startup_music_player.model.Contract.ContractHome
import com.example.startup_music_player.model.data.MusicRespomse
import com.example.startup_music_player.model.net.createApiService
import com.example.startup_music_player.model.presenter.PresenterHome
import com.example.startup_music_player.util.NetworkChecker
import com.squareup.picasso.Picasso


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
        presenter = PresenterHome(createApiService(), NetworkChecker(binding.root.context).isInternetConnected)
         lifecycleScope.launchWhenCreated {
             presenter.OnAttach(this@HomeFragment)
         }

        binding.mouduleOneHome.slider.setItemClickListener(object : ItemClickListener {
            override fun onItemSelected(position: Int) {
                when(position){
                    0 ->{
                        Log.v("test","0")
                    }
                    1 ->{
                        Log.v("test","1")
                    }
                    2 ->{
                        Log.v("test","3")
                    }
                }
            }
        })

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


    override fun ShowTopMusik(data: List<MusicRespomse>) {

        val dataMusic = arrayListOf<MusicRespomse>(
            MusicRespomse("f" ,"f", "" , "gg"),
            MusicRespomse("f" ,"f", "" , "gg"),
            MusicRespomse("f" ,"f", "" , "gg"),
        )


        val adapter = HomeAdapter(dataMusic,this)
        binding.mouduleTwoHome.recTopMusic.layoutManager = GridLayoutManager(context ,2, RecyclerView.HORIZONTAL, false)
        binding.mouduleTwoHome.recTopMusic.adapter = adapter
        Log.v("TAgw",data.toString())
        Log.v("testii" , dataMusic.toString())



    }

    override fun ShowTopViewMusik(data: List<MusicRespomse>) {

    }

    override fun ShowGuropMusik(data: List<MusicRespomse>) {
    }
    override fun Click(data: MusicRespomse) {

    }
}