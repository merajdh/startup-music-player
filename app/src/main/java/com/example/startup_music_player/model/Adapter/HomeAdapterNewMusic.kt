package com.example.startup_music_player.model.Adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.startup_music_player.databinding.ItemRecyclerRecentmusicBinding
import com.example.startup_music_player.databinding.ItemRecyclerTopMusicHomeBinding
import com.example.startup_music_player.model.InteFaces.OnClickHome
import com.example.startup_music_player.model.data.MusicNewsRespomse
import com.example.startup_music_player.model.data.MusicRespomse
import com.squareup.picasso.Picasso

class HomeAdapterNewMusic(private val data : List<MusicNewsRespomse>, private val OnClick: OnClickHome) :RecyclerView.Adapter<HomeAdapterNewMusic.HomeNewMusicViewHolder>() {

        inner class HomeNewMusicViewHolder(private var binding:ItemRecyclerRecentmusicBinding
        ) : RecyclerView.ViewHolder(binding.root){
            fun ViewBinder (dataHome: MusicNewsRespomse){
                binding.txtNameMusic.text = dataHome.title
                binding.txtNameSinger.text = dataHome.artist[0].toString()
                Picasso
                    .get()
                    .load(dataHome.cover)
                    .into(binding.imgCover)

                itemView.setOnClickListener {
                    OnClick.Click_MusicNews(dataHome)
                }

            }
        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HomeNewMusicViewHolder {
        var binding = ItemRecyclerRecentmusicBinding.inflate(LayoutInflater.from(parent.context) , parent , false)
        return HomeNewMusicViewHolder(binding)
    }

    override fun onBindViewHolder(holder: HomeNewMusicViewHolder, position: Int) {
        holder.ViewBinder(data[position])
    }

    override fun getItemCount(): Int {
        return data.size
    }


}