package com.example.startup_music_player.model.Adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.startup_music_player.databinding.ItemRecyclerHappyHomeBinding
import com.example.startup_music_player.model.InteFaces.OnClickHome
import com.example.startup_music_player.model.data.MusicByCategoryRespomse
import com.example.startup_music_player.model.data.MusicRespomse
import com.squareup.picasso.Picasso

class HomeAdapterHappyMusic(private val data: List<MusicByCategoryRespomse>, private val OnClick: OnClickHome) : RecyclerView.Adapter<HomeAdapterHappyMusic.HomeHappyMusicViewHolder>() {

    inner class HomeHappyMusicViewHolder(private var binding: ItemRecyclerHappyHomeBinding
    ) : RecyclerView.ViewHolder(binding.root) {
        fun ViewBinder(dataHome: MusicByCategoryRespomse) {
            binding.txtNameMusic.text = dataHome.title
            binding.txtNameSinger.text = dataHome.artist[0].toString()
            Picasso
                .get()
                .load(dataHome.cover)
                .into(binding.imgCover)

            itemView.setOnClickListener {
                OnClick.Click_MusicByCategory(dataHome)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HomeHappyMusicViewHolder {
        var binding = ItemRecyclerHappyHomeBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return HomeHappyMusicViewHolder(binding)
    }

    override fun onBindViewHolder(holder: HomeHappyMusicViewHolder, position: Int) {
        holder.ViewBinder(data[position])
    }

    override fun getItemCount(): Int {
        return data.size
    }
}


