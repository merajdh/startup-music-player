package com.example.startup_music_player.model.Adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.startup_music_player.databinding.ItemRecyclerMusicbycategoryBinding
import com.example.startup_music_player.model.InteFaces.OnClickMusicByCategory
import com.example.startup_music_player.model.data.MusicByCategoryData
import com.example.startup_music_player.util.MyApp

class MusicByCategoryAdapter(
    private val data: List<MusicByCategoryData>,
    private val onClickMusicByCategory: OnClickMusicByCategory
) : RecyclerView.Adapter<MusicByCategoryAdapter.MusicByCategoryViewHolder>() {


    inner class MusicByCategoryViewHolder(private var binding: ItemRecyclerMusicbycategoryBinding
    ) : RecyclerView.ViewHolder(binding.root) {
        fun ViewBinder(dataMusic: MusicByCategoryData) {

            MyApp.idArtist = dataMusic.id.toString()
            binding.txtNameMusic.text = dataMusic.title
            binding.nameArtist.text = dataMusic.artist.toString().replace("[", "").replace("]", "")
            Glide.with(binding.root).load(dataMusic.cover)
                .into(binding.imgCover)

            itemView.setOnClickListener {
                onClickMusicByCategory.onClickMusicByCategory(dataMusic)
            }

        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MusicByCategoryViewHolder {
        var binding = ItemRecyclerMusicbycategoryBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return MusicByCategoryViewHolder(binding)
    }

    override fun onBindViewHolder(holder: MusicByCategoryViewHolder, position: Int) {
        holder.ViewBinder(data[position])
    }

    override fun getItemCount(): Int {
        return data.size
    }
}