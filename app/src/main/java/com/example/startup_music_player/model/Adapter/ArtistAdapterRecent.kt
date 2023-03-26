package com.example.startup_music_player.model.Adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.startup_music_player.databinding.ItemRecyclerPopularmusicBinding
import com.example.startup_music_player.databinding.ItemRecyclerTopMusicHomeBinding
import com.example.startup_music_player.model.data.DetailArtistRespomse
import com.squareup.picasso.Picasso


class ArtistAdapterRecent(private val data: List<DetailArtistRespomse.RecentMusic> , private val onClickArtist: OnClickArtist) :
    RecyclerView.Adapter<ArtistAdapterRecent.ArtistPopularViewHolder>() {
    lateinit var binding: ItemRecyclerTopMusicHomeBinding

    inner class ArtistPopularViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun ViewBinder(dataArtist: DetailArtistRespomse.RecentMusic) {

            Picasso.get().load(dataArtist.cover).into(binding.imgCover)
            binding.txtNameMusic.text = dataArtist.title
            binding.txtNameSinger.text = dataArtist.artist.toString()

            itemView.setOnClickListener {
                onClickArtist.recentMusic(dataArtist)
            }

        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ArtistPopularViewHolder {
        binding = ItemRecyclerTopMusicHomeBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return ArtistPopularViewHolder(binding.root)
    }

    override fun onBindViewHolder(holder: ArtistPopularViewHolder, position: Int) {
        holder.ViewBinder(data[position])
    }

    override fun getItemCount(): Int {
        return data.size
    }
}