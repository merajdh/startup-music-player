package com.example.startup_music_player.model.Adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.startup_music_player.databinding.ItemRecyclerTopMusicHomeBinding
import com.example.startup_music_player.model.InteFaces.OnClickArtist
import com.example.startup_music_player.model.data.DetailArtistRespomse
import com.squareup.picasso.Picasso


class ArtistAdapterRecent(private val data: List<DetailArtistRespomse.RecentMusic> , private val onClickArtist: OnClickArtist) :
    RecyclerView.Adapter<ArtistAdapterRecent.ArtistPopularViewHolder>() {

    inner class ArtistPopularViewHolder(private var binding: ItemRecyclerTopMusicHomeBinding
    ) : RecyclerView.ViewHolder(binding.root) {
        fun ViewBinder(dataArtist: DetailArtistRespomse.RecentMusic) {

            Picasso.get().load(dataArtist.cover).into(binding.imgCover)
            binding.txtNameMusic.text = dataArtist.title
            binding.txtNameSinger.text = dataArtist.artist.toString().replace("[" , "").replace("]", "")

            itemView.setOnClickListener {
                onClickArtist.recentMusic(dataArtist)
            }

        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ArtistPopularViewHolder {
        var binding = ItemRecyclerTopMusicHomeBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return ArtistPopularViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ArtistPopularViewHolder, position: Int) {
        holder.ViewBinder(data[position])
    }

    override fun getItemCount(): Int {
        return data.size
    }
}