package com.example.startup_music_player.model.Adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.startup_music_player.databinding.ItemRecyclerHappyHomeBinding
import com.example.startup_music_player.model.data.MusicRespomse
import com.squareup.picasso.Picasso

class HomeAdapterHappyMusic(private val data: ArrayList<MusicRespomse>) : RecyclerView.Adapter<HomeAdapterHappyMusic.HomeHappyMusicViewHolder>() {
    lateinit var binding: ItemRecyclerHappyHomeBinding

    inner class HomeHappyMusicViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun ViewBinder(dataHome: MusicRespomse) {
            binding.txtNameMusic.text = dataHome.name
            binding.txtNameSinger.text = dataHome.nemeArtist
            Picasso
                .get()
                .load(dataHome.Cover.toString())
                .into(binding.imgCover)

        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HomeHappyMusicViewHolder {
        binding =
            ItemRecyclerHappyHomeBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return HomeHappyMusicViewHolder(binding.root)
    }

    override fun onBindViewHolder(holder: HomeHappyMusicViewHolder, position: Int) {
        holder.ViewBinder(data[position])
    }

    override fun getItemCount(): Int {
        return data.size
    }
}


