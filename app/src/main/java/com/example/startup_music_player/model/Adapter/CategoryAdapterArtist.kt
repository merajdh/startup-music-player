package com.example.startup_music_player.model.Adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.startup_music_player.databinding.ItemRecyclerArtistBinding
import com.example.startup_music_player.model.InteFaces.OnClickCategory
import com.example.startup_music_player.model.data.ListArtistData
import com.example.startup_music_player.util.MyApp
import com.squareup.picasso.Picasso

class CategoryAdapterArtist(private val data: List<ListArtistData>, private val onClickCategory: OnClickCategory) : RecyclerView.Adapter<CategoryAdapterArtist.CategoryArtistViewHolder>() {
    lateinit var binding: ItemRecyclerArtistBinding

    inner class CategoryArtistViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun ViewBinder(dataArtist: ListArtistData) {

            MyApp.idArtist = dataArtist.id.toString()
            binding.artistName.text = dataArtist.ArtistName
            Picasso.get().load(dataArtist.cover).into(binding.ImgArtist)
            itemView.setOnClickListener {
                onClickCategory.OnClickArtist(dataArtist)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CategoryArtistViewHolder {
        binding = ItemRecyclerArtistBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return CategoryArtistViewHolder(binding.root)
    }

    override fun onBindViewHolder(holder: CategoryArtistViewHolder, position: Int) {
        holder.ViewBinder(data[position])
    }

    override fun getItemCount(): Int {
        return data.size
    }
}