package com.example.startup_music_player.ui.features.Main

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.viewpager.widget.ViewPager
import androidx.viewpager2.widget.ViewPager2
import com.example.startup_music_player.R
import com.example.startup_music_player.databinding.FragmentMainBinding
import com.example.startup_music_player.model.Adapter.ViewPagerPlayAdapter
import com.example.startup_music_player.ui.Fragment.ProfileFragment
import com.example.startup_music_player.ui.features.Category.CategoryFragment
import com.example.startup_music_player.ui.features.Home.HomeFragment
import com.example.startup_music_player.ui.features.Play.PlayFragment
import com.example.startup_music_player.ui.features.Serach.SearchFragment
import com.example.startup_music_player.util.MyApp
import java.util.*

class MainFragment : Fragment() {
    lateinit var binding: FragmentMainBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentMainBinding.inflate(layoutInflater, container, false)

        binding.viewPagerMain.visibility = View.GONE
        if (MyApp.media != null) {
            binding.viewPagerMain.visibility = View.VISIBLE
            var adapter = ViewPagerPlayAdapter(this)
            binding.viewPagerMain.adapter = adapter
            binding.viewPagerMain.orientation = ViewPager2.ORIENTATION_HORIZONTAL

            val timer = Timer()
            timer.schedule(object  : TimerTask(){
                override fun run() {
                    activity?.runOnUiThread {
                        if (binding.viewPagerMain.currentItem == 1) {
                            MyApp.media?.stop()
                            MyApp.media?.release()
                            MyApp.media = null
                            binding.viewPagerMain.visibility = View.GONE
                            binding.viewPagerMain.adapter = null
                        }
                    }
                }
            },1000 , 1000)
        }

        Run()
        SelectedbtnNavigeyshen()


        Log.v("currentItem", binding.viewPagerMain.currentItem.toString())

        return binding.root
    }


    private fun SelectedbtnNavigeyshen() {
        binding.butennavigetion.setOnItemSelectedListener {
            when (it) {
                R.id.Profile -> {
                    transform(ProfileFragment())
                }
                R.id.home -> {
                    transform(HomeFragment())
                }
                R.id.category -> {
                    transform(CategoryFragment())
                }
                R.id.search -> {
                    transform(SearchFragment())
                }
            }

        }
    } // the transfer fragment

    private fun transform(fragment: Fragment) {
        val transform = parentFragmentManager.beginTransaction()
        transform.replace(R.id.FrameLayout, fragment)
        transform.commit()
    } // transform btn navigeshen

    private fun Run() {
        transform(HomeFragment())
        binding.butennavigetion.setItemSelected(R.id.home) // Select the executed item


    } // Run every time


}