package com.example.startup_music_player.model.Adapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Lifecycle
import androidx.viewpager2.adapter.FragmentStateAdapter
import androidx.viewpager2.adapter.FragmentViewHolder
import com.example.startup_music_player.databinding.FragmentMinimizePlayBinding
import com.example.startup_music_player.ui.features.Main.MainFragment
import com.example.startup_music_player.ui.features.Play.minimizePlayFragment


class ViewPagerPlayAdapter(fragment: Fragment)  : FragmentStateAdapter(fragment)   {

    lateinit var binding:FragmentMinimizePlayBinding
    override fun onBindViewHolder(
        holder: FragmentViewHolder,
        position: Int,
        payloads: MutableList<Any>
    ) {


        super.onBindViewHolder(holder, position, payloads)
    }


    override fun createFragment(position: Int): Fragment {
        when(position){
            0 -> {
                return minimizePlayFragment()
            }
            1->{
                return Fragment()
            }

            else -> {
                return Fragment()
            }
        }

    }
    override fun getItemCount(): Int {
        return 3
    }


}