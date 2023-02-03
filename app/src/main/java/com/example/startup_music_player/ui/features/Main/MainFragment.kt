package com.example.startup_music_player.ui.features.Main

import android.os.Bundle
import android.view.*
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.example.startup_music_player.R
import com.example.startup_music_player.databinding.FragmentMainBinding
import com.example.startup_music_player.ui.Fragment.ProfileFragment
import com.example.startup_music_player.ui.features.Category.CategoryFragment
import com.example.startup_music_player.ui.features.Home.HomeFragment
import com.example.startup_music_player.ui.features.Serach.SearchFragment

class MainFragment : Fragment() {
    lateinit var binding : FragmentMainBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentMainBinding.inflate(layoutInflater,container,false)
        (activity as AppCompatActivity).setSupportActionBar(binding.toolbarmain) // set tolbar
        SelectedbtnNavigeyshen()
        Run()
        return binding.root
    }


    private fun SelectedbtnNavigeyshen() {
        binding.butennavigetion.setOnItemSelectedListener {
            when(it){
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
    private fun transform(fragment : Fragment){
        val transform = parentFragmentManager.beginTransaction()
        transform.replace(R.id.FrameLayout,fragment)
        transform.commit()
    } // transform btn navigeshen
    private fun Run(){
        transform(HomeFragment()) // Added run time Fragment
        binding.butennavigetion.setItemSelected( R.id.home) // Select the executed item
    } // Run every time

}