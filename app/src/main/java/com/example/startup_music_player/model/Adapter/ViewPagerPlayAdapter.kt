package com.example.startup_music_player.model.Adapter

import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import androidx.viewpager2.widget.ViewPager2
import com.example.startup_music_player.ui.features.Main.MainFragment
import com.example.startup_music_player.ui.features.Play.minimizePlayFragment
import com.example.startup_music_player.ui.features.playDetail.playDetailFragment

class ViewPagerPlayAdapter(fragment: MainFragment)  : FragmentStateAdapter(fragment)  {


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