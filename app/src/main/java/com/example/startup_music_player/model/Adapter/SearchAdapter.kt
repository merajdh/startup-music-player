package com.example.startup_music_player.model.Adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.startup_music_player.databinding.ItemRecyclerHappyHomeBinding
import com.example.startup_music_player.databinding.ItemRecyclerTopMusicHomeBinding
import com.example.startup_music_player.model.InteFaces.OnClickHome
import com.example.startup_music_player.model.data.MusicRespomse
import com.squareup.picasso.Picasso

class SearchAdapter(private val data: List<MusicRespomse>) : RecyclerView.Adapter<SearchAdapter.SearchViewHolder>() {

    inner class SearchViewHolder(private var binding: ItemRecyclerTopMusicHomeBinding
    ) : RecyclerView.ViewHolder(binding.root) {
        fun ViewBinder(data : MusicRespomse) {
            binding.txtNameMusic.text = data.title
            binding.txtNameSinger.text = data.artist[0]
            Picasso.get().load(data.cover).into(binding.imgCover)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SearchViewHolder {
        var binding = ItemRecyclerTopMusicHomeBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return SearchViewHolder(binding)
    }

    override fun onBindViewHolder(holder: SearchViewHolder, position: Int) {
        holder.ViewBinder(data[position])
    }

    override fun getItemCount(): Int {
        return data.size
    }
}


