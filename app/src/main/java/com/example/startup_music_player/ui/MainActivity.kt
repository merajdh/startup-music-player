package com.example.startup_music_player.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.core.content.ContextCompat
import androidx.core.graphics.toColor
import com.example.startup_music_player.R
import com.example.startup_music_player.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityMainBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        SelectedbtnNavigeyshen() // BtnNavigeyshen
    }
    private fun SelectedbtnNavigeyshen() {
        binding.btnNavigeyshen.setOnItemSelectedListener {
            when (it.itemId) {
                R.id.home -> {
                    binding.selectedCategory.visibility = View.INVISIBLE
                    binding.selectedProfile.visibility = View.INVISIBLE
                    binding.selectedHome.visibility = View.VISIBLE
                }
                R.id.category -> {
                    binding.selectedHome.visibility = View.INVISIBLE
                    binding.selectedProfile.visibility = View.INVISIBLE
                    binding.selectedCategory.visibility = View.VISIBLE
                }
                R.id.Profile -> {
                    binding.selectedHome.visibility = View.INVISIBLE
                    binding.selectedCategory.visibility = View.INVISIBLE
                    binding.selectedProfile.visibility = View.VISIBLE
                }
            }

            true
        }
    }
}