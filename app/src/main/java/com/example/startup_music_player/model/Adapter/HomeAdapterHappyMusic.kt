package com.example.startup_music_player.model.Adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.startup_music_player.databinding.ItemRecyclerHappyHomeBinding
import com.example.startup_music_player.model.data.MusicRespomse
import com.squareup.picasso.Picasso

class HomeAdapterHappyMusic(private val data: List<MusicRespomse> , private val OnClick:OnClick) : RecyclerView.Adapter<HomeAdapterHappyMusic.HomeHappyMusicViewHolder>() {
    lateinit var binding: ItemRecyclerHappyHomeBinding

    inner class HomeHappyMusicViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun ViewBinder(dataHome: MusicRespomse) {
            binding.txtNameMusic.text = dataHome.title
            binding.txtNameSinger.text = dataHome.artist
            Picasso
                .get()
                .load(dataHome.Cover)
                .into(binding.imgCover)

            itemView.setOnClickListener {
                OnClick.Click(dataHome)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HomeHappyMusicViewHolder {
        binding = ItemRecyclerHappyHomeBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return HomeHappyMusicViewHolder(binding.root)
    }

    override fun onBindViewHolder(holder: HomeHappyMusicViewHolder, position: Int) {
        holder.ViewBinder(data[position])
    }

    override fun getItemCount(): Int {
        return data.size
    }
}


