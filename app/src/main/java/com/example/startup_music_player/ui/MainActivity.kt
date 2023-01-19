package com.example.startup_music_player.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.Toast
import androidx.core.content.ContextCompat
import androidx.core.graphics.toColor
import com.denzcoskun.imageslider.models.SlideModel
import com.example.startup_music_player.R
import com.example.startup_music_player.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityMainBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        SelectedbtnNavigeyshen() // BtnNavigeyshen
        AddsliderCod() // slider
    }


    private fun SelectedbtnNavigeyshen() {
        binding.butennavigetion.setItemSelected( R.id.item1)
        binding.butennavigetion.setOnItemSelectedListener {
            when(it){
                R.id.item0 -> {

                }
                R.id.item1 -> {

                }
                R.id.item2 -> {

                }
            }

        }
    }


    private fun AddsliderCod() {
        val ItemSlider = ArrayList<SlideModel>()
        ItemSlider.add(SlideModel("https://images.hdqwalls.com/download/eminem-rapper-wallpaper-2560x1440.jpg"))
        ItemSlider.add(SlideModel("https://images4.alphacoders.com/193/193108.jpg"))
        ItemSlider.add(SlideModel("https://wallpaper.dog/large/17006205.jpg"))
        binding.slider.setImageList(ItemSlider)

    }

}