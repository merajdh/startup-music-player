package com.example.startup_music_player.model.Adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.startup_music_player.databinding.*
import com.example.startup_music_player.model.InteFaces.OnClickHome
import com.example.startup_music_player.model.data.MusicRespomse
import com.squareup.picasso.Picasso

class LikedMusicAdapter(private val data: List<MusicRespomse>) : RecyclerView.Adapter<LikedMusicAdapter.LikedMusicHolder>() {

    inner class LikedMusicHolder(private var binding: ItemRecyclerMusicbycategoryBinding
    ) : RecyclerView.ViewHolder(binding.root) {
        fun ViewBinder(data : MusicRespomse) {
            binding.txtNameMusic.text = data.title
            binding.nameArtist.text = data.artist[0]
            Picasso.get().load(data.cover).into(binding.imgCover)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): LikedMusicHolder {
        var binding = ItemRecyclerMusicbycategoryBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return LikedMusicHolder(binding)
    }

    override fun onBindViewHolder(holder: LikedMusicHolder, position: Int) {
        holder.ViewBinder(data[position])
    }

    override fun getItemCount(): Int {
        return data.size
    }
}


