package com.example.startup_music_player.model.Adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.startup_music_player.databinding.ItemRecyclerTopMusicHomeBinding
import com.example.startup_music_player.model.InteFaces.OnClickHome
import com.example.startup_music_player.model.data.MusicRespomse
import com.example.startup_music_player.model.data.MusicTopRespomse
import com.squareup.picasso.Picasso

class HomeAdapterTopMusic( private val data : List<MusicTopRespomse>, private val OnClick: OnClickHome) :RecyclerView.Adapter<HomeAdapterTopMusic.HomeViewHolder>() {

        inner class HomeViewHolder(private var binding : ItemRecyclerTopMusicHomeBinding) : RecyclerView.ViewHolder(binding.root){
            fun ViewBinder (dataHome: MusicTopRespomse){
                binding.txtNameMusic.text = dataHome.title
                binding.txtNameSinger.text = dataHome.artist[0].toString()
                Picasso
                    .get()
                    .load(dataHome.cover)
                    .into(binding.imgCover)

                itemView.setOnClickListener {
                    OnClick.Click_MusicTop(dataHome)
                }

            }
        }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HomeViewHolder {

        val binding = ItemRecyclerTopMusicHomeBinding.inflate(LayoutInflater.from(parent.context) , parent , false)
        return HomeViewHolder(binding)
    }

    override fun onBindViewHolder(holder: HomeViewHolder, position: Int) {
        holder.ViewBinder(data[position])
    }

    override fun getItemCount(): Int {
        return data.size
    }


}