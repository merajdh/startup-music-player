package com.example.startup_music_player.ui.features.Home

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.denzcoskun.imageslider.constants.ScaleTypes
import com.denzcoskun.imageslider.interfaces.ItemClickListener
import com.denzcoskun.imageslider.models.SlideModel
import com.example.startup_music_player.databinding.FragmentHomeBinding
import com.example.startup_music_player.model.Adapter.HomeAdapterTopMusic
import com.example.startup_music_player.model.Adapter.HomeAdapterHappyMusic
import com.example.startup_music_player.model.Adapter.HomeAdapterNewMusic
import com.example.startup_music_player.model.Adapter.OnClick
import com.example.startup_music_player.model.Contract.ContractHome
import com.example.startup_music_player.model.data.MusicRespomse
import com.example.startup_music_player.model.myApp.myApp
import com.example.startup_music_player.model.net.createApiService
import com.example.startup_music_player.model.presenter.PresenterHome
import com.example.startup_music_player.util.NetworkChecker


class HomeFragment : Fragment() , ContractHome.View , OnClick{
    lateinit var binding: FragmentHomeBinding
    lateinit var presenter: ContractHome.Presenter
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        binding = FragmentHomeBinding.inflate(layoutInflater,container,false)
        AddsliderCod() // slider
        setOnClickListeners()
        MoreClickListener()
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

    override fun ShowPartiMusik(data: String) {

        val dataMusic = arrayListOf<MusicRespomse>(
            MusicRespomse("کی مثل من" ,"امیر تتلو", "https://images.hdqwalls.com/download/eminem-rapper-wallpaper-2560x1440.jpg" , "شاد"),
            MusicRespomse("کی مثل من" ,"امیر تتلو", "https://images.hdqwalls.com/download/eminem-rapper-wallpaper-2560x1440.jpg" , "شاد"),
            MusicRespomse("کی مثل من" ,"امیر تتلو", "https://images.hdqwalls.com/download/eminem-rapper-wallpaper-2560x1440.jpg" , "شاد"),
            MusicRespomse("کی مثل من" ,"امیر تتلو", "https://images.hdqwalls.com/download/eminem-rapper-wallpaper-2560x1440.jpg" , "شاد"),
            MusicRespomse("کی مثل من" ,"امیر تتلو", "https://images.hdqwalls.com/download/eminem-rapper-wallpaper-2560x1440.jpg" , "شاد"),
            MusicRespomse("کی مثل من" ,"امیر تتلو", "https://images.hdqwalls.com/download/eminem-rapper-wallpaper-2560x1440.jpg" , "شاد"),
            MusicRespomse("کی مثل من" ,"امیر تتلو", "https://images.hdqwalls.com/download/eminem-rapper-wallpaper-2560x1440.jpg" , "شاد"),
        )

        val adapter = HomeAdapterHappyMusic(dataMusic, this)
        binding.mouduleOneHome.recHappyMusic.layoutManager = GridLayoutManager(context ,1, RecyclerView.HORIZONTAL, true)
        binding.mouduleOneHome.recHappyMusic.adapter = adapter

    }


    override fun ShowTopMusik(data: String) {

        val dataMusic = arrayListOf<MusicRespomse>(
            MusicRespomse("کی مثل من" ,"امیر تتلو", "https://images.hdqwalls.com/download/eminem-rapper-wallpaper-2560x1440.jpg" , "شاد"),
            MusicRespomse("کی مثل من" ,"امیر تتلو", "https://images.hdqwalls.com/download/eminem-rapper-wallpaper-2560x1440.jpg" , "شاد"),
            MusicRespomse("کی مثل من" ,"امیر تتلو", "https://images.hdqwalls.com/download/eminem-rapper-wallpaper-2560x1440.jpg" , "شاد"),
            MusicRespomse("کی مثل من" ,"امیر تتلو", "https://images.hdqwalls.com/download/eminem-rapper-wallpaper-2560x1440.jpg" , "شاد"),
            MusicRespomse("کی مثل من" ,"امیر تتلو", "https://images.hdqwalls.com/download/eminem-rapper-wallpaper-2560x1440.jpg" , "شاد"),
            MusicRespomse("کی مثل من" ,"امیر تتلو", "https://images.hdqwalls.com/download/eminem-rapper-wallpaper-2560x1440.jpg" , "شاد"),
            MusicRespomse("کی مثل من" ,"امیر تتلو", "https://images.hdqwalls.com/download/eminem-rapper-wallpaper-2560x1440.jpg" , "شاد"),
        )

        val adapter = HomeAdapterTopMusic(dataMusic, this)
        binding.mouduleTwoHome.recTopMusic.layoutManager = GridLayoutManager (context , 2 , RecyclerView.HORIZONTAL , true)
        binding.mouduleTwoHome.recTopMusic.adapter = adapter
    }

    override fun ShowTopViewMusik(data: String) {


    }
    override fun ShowGuropMusik(data: String) {

        val dataMusic = arrayListOf<MusicRespomse>(
            MusicRespomse("کی مثل من" ,"امیر تتلو", "https://images.hdqwalls.com/download/eminem-rapper-wallpaper-2560x1440.jpg" , "شاد"),
            MusicRespomse("کی مثل من" ,"امیر تتلو", "https://images.hdqwalls.com/download/eminem-rapper-wallpaper-2560x1440.jpg" , "شاد"),
            MusicRespomse("کی مثل من" ,"امیر تتلو", "https://images.hdqwalls.com/download/eminem-rapper-wallpaper-2560x1440.jpg" , "شاد"),
            MusicRespomse("کی مثل من" ,"امیر تتلو", "https://images.hdqwalls.com/download/eminem-rapper-wallpaper-2560x1440.jpg" , "شاد"),
            MusicRespomse("کی مثل من" ,"امیر تتلو", "https://images.hdqwalls.com/download/eminem-rapper-wallpaper-2560x1440.jpg" , "شاد"),
            MusicRespomse("کی مثل من" ,"امیر تتلو", "https://images.hdqwalls.com/download/eminem-rapper-wallpaper-2560x1440.jpg" , "شاد"),
            MusicRespomse("کی مثل من" ,"امیر تتلو", "https://images.hdqwalls.com/download/eminem-rapper-wallpaper-2560x1440.jpg" , "شاد"),
        )

         val adapter = HomeAdapterNewMusic(dataMusic, this)
        binding.mouduleThreeHome.recNewMusic.layoutManager = LinearLayoutManager(context , RecyclerView.VERTICAL , false)
        binding.mouduleThreeHome.recNewMusic.adapter = adapter
    }

    override fun Click(data: MusicRespomse) {
        //test interface
        Toast.makeText(context, data.NameMusic, Toast.LENGTH_SHORT).show()
    }

    fun setOnClickListeners(){

        binding.mouduleOneHome.btnMore.setOnClickListener {
            myApp.ischeckd = "happy_music"
            MoreClickListener()
        }

        binding.mouduleTwoHome.btnMore.setOnClickListener {
            myApp.ischeckd = "top_music"
            MoreClickListener()
        }

        binding.mouduleThreeHome.btnMore.setOnClickListener {
            myApp.ischeckd = "new_music"
            MoreClickListener()

        }
    }

    private fun MoreClickListener(){



        when(myApp.ischeckd){
            "happy_music" -> {
                Toast.makeText(context, "happy_music", Toast.LENGTH_SHORT).show()
            }

            "top_music" -> {
                Toast.makeText(context, "top_music", Toast.LENGTH_SHORT).show()
            }

            "new_music" -> {
                Toast.makeText(context, "new_music", Toast.LENGTH_SHORT).show()

            }


        }
    }

}