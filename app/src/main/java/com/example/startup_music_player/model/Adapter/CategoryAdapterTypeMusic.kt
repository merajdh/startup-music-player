package com.example.startup_music_player.model.Adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.example.startup_music_player.databinding.ItemRecyclerMusictypeCategoryBinding
import com.example.startup_music_player.model.data.CategoryRespomse
import com.squareup.picasso.Picasso
import jp.wasabeef.glide.transformations.BlurTransformation

class CategoryAdapterTypeMusic(private val data: List<CategoryRespomse>, private val onClickCategory: OnClickCategory ) : RecyclerView.Adapter<CategoryAdapterTypeMusic.CategoryMusicTypeViewHolder>() {
    lateinit var binding: ItemRecyclerMusictypeCategoryBinding

    inner class CategoryMusicTypeViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun ViewBinder(dataHome: CategoryRespomse) {

            binding.txtType.text = dataHome.typeCategory

            Glide.with(binding.root.context).load(dataHome.cover)
                .apply(RequestOptions.bitmapTransform(BlurTransformation(2, 2)))
                .into(binding.imgCover)

            itemView.setOnClickListener {
                onClickCategory.ClickCategory(dataHome)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CategoryMusicTypeViewHolder {
        binding = ItemRecyclerMusictypeCategoryBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return CategoryMusicTypeViewHolder(binding.root)
    }

    override fun onBindViewHolder(holder: CategoryMusicTypeViewHolder, position: Int) {
        holder.ViewBinder(data[position])
    }

    override fun getItemCount(): Int {
        return data.size
    }
}