package com.example.startup_music_player.ui.features.Category

import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.example.startup_music_player.databinding.FragmentCategoryBinding
import com.example.startup_music_player.model.myApp.myApp

class CategoryFragment : Fragment() {
    lateinit var binding: FragmentCategoryBinding
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        binding = FragmentCategoryBinding.inflate(layoutInflater,container,false)
        setOnClickListeners()
        MoreClickListener()
        return binding.root
    }

    private fun setOnClickListeners(){

        binding.swipeCategory.setOnRefreshListener {
            // load data hare

            Handler (Looper.getMainLooper()).postDelayed({
                binding.swipeCategory.isRefreshing = false

            },800)
        }

        //moudule Two ->

        binding.mouduleOneCategory.btnMore.setOnClickListener {
            myApp.ischeckd = "category_music"
            MoreClickListener()
        }

        //moudule One ->

        binding.mouduleTwoCategory.btnMore.setOnClickListener {
            myApp.ischeckd = "artist"
            MoreClickListener()
        }

        binding.mouduleTwoCategory.btnMoreInternational.setOnClickListener {
            myApp.ischeckd = "international"
            MoreClickListener()
        }
    }

    private fun MoreClickListener() {

        when (myApp.ischeckd) {
            "category_music" -> {
                Toast.makeText(context, "category_music", Toast.LENGTH_SHORT).show()
            }

            "artist" -> {
                Toast.makeText(context, "artist", Toast.LENGTH_SHORT).show()
            }

            "international" -> {
                Toast.makeText(context, "international", Toast.LENGTH_SHORT).show()
            }


        }
    }

}