package com.example.startup_music_player.model.Adapter

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.startup_music_player.databinding.ItemRecyclerTopMusicHomeBinding
import com.example.startup_music_player.model.data.MusicRespomse
import com.squareup.picasso.Picasso

class HomeAdapterNewMusic(private val data : ArrayList<MusicRespomse> ) :RecyclerView.Adapter<HomeAdapterNewMusic.HomeNewMusicViewHolder>() {
    lateinit var binding:ItemRecyclerTopMusicHomeBinding

        inner class HomeNewMusicViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
            fun ViewBinder (dataHome: MusicRespomse){
                binding.txtNameMusic.text = dataHome.NameMusic
                binding.txtNameSinger.text = dataHome.NAmeArtist
                Picasso
                    .get()
                    .load(dataHome.Cover)
                    .into(binding.imgCover)


            }
        }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HomeNewMusicViewHolder {
        binding = ItemRecyclerTopMusicHomeBinding.inflate(LayoutInflater.from(parent.context) , parent , false)
        return HomeNewMusicViewHolder(binding.root)
    }

    override fun onBindViewHolder(holder: HomeNewMusicViewHolder, position: Int) {
        holder.ViewBinder(data[position])
    }

    override fun getItemCount(): Int {
        return data.size
    }


}