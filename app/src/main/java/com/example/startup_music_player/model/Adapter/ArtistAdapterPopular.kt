package com.example.startup_music_player.model.Adapter

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.airbnb.lottie.L
import com.example.startup_music_player.databinding.ItemRecyclerPopularmusicBinding
import com.example.startup_music_player.model.data.DetailArtistRespomse
import com.squareup.picasso.Picasso


class ArtistAdapterPopular(private val data: List<DetailArtistRespomse.PopularMusic> , private val onClickArtist: OnClickArtist) :
    RecyclerView.Adapter<ArtistAdapterPopular.ArtistPopularViewHolder>() {
    lateinit var binding: ItemRecyclerPopularmusicBinding

    inner class ArtistPopularViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun ViewBinder(dataArtist: DetailArtistRespomse.PopularMusic) {

            Picasso.get().load(dataArtist.cover).into(binding.imgCover)
            binding.txtNameMusic.text = dataArtist.title
            binding.txtNameSinger.text = dataArtist.artist.toString().replace("[" , "").replace("]", "")
            Log.v("testt" , dataArtist.cover)
            itemView.setOnClickListener {
                onClickArtist.popularMusic(dataArtist)
            }
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ArtistPopularViewHolder {
        binding = ItemRecyclerPopularmusicBinding.inflate(
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