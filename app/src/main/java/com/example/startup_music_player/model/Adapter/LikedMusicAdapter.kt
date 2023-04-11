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
    lateinit var binding: ItemRecyclerMusicbycategoryBinding

    inner class LikedMusicHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun ViewBinder(data : MusicRespomse) {
            binding.txtNameMusic.text = data.title
            binding.nameArtist.text = data.artist[0]
            Picasso.get().load(data.cover).into(binding.imgCover)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): LikedMusicHolder {
        binding = ItemRecyclerMusicbycategoryBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return LikedMusicHolder(binding.root)
    }

    override fun onBindViewHolder(holder: LikedMusicHolder, position: Int) {
        holder.ViewBinder(data[position])
    }

    override fun getItemCount(): Int {
        return data.size
    }
}


