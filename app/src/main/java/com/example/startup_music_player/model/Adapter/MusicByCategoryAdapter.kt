package com.example.startup_music_player.model.Adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.example.startup_music_player.databinding.ItemRecyclerMusicbycategoryBinding
import com.example.startup_music_player.model.data.MusicByCategoryData
import com.example.startup_music_player.util.MyApp
import jp.wasabeef.glide.transformations.BlurTransformation

class MusicByCategoryAdapter(
    private val data: List<MusicByCategoryData>,
    private val onClickMusicByCategory: OnClickMusicByCategory
) : RecyclerView.Adapter<MusicByCategoryAdapter.MusicByCategoryViewHolder>() {
    lateinit var binding: ItemRecyclerMusicbycategoryBinding


    inner class MusicByCategoryViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun ViewBinder(dataMusic: MusicByCategoryData) {

            MyApp.idArtist = dataMusic.id.toString()
            binding.txtNameMusic.text = dataMusic.title
            binding.nameArtist.text = dataMusic.artist.toString().replace("[", "").replace("]", "")
            Glide.with(binding.root).load(dataMusic.cover)
                .apply(RequestOptions.bitmapTransform(BlurTransformation(8, 2)))
                .into(binding.imgCover)

            itemView.setOnClickListener {
                onClickMusicByCategory.MusicByCategory(dataMusic)
            }

        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MusicByCategoryViewHolder {
        binding = ItemRecyclerMusicbycategoryBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return MusicByCategoryViewHolder(binding.root)
    }

    override fun onBindViewHolder(holder: MusicByCategoryViewHolder, position: Int) {
        holder.ViewBinder(data[position])
    }

    override fun getItemCount(): Int {
        return data.size
    }
}