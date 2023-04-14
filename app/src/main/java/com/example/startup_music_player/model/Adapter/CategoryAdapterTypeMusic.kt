package com.example.startup_music_player.model.Adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.example.startup_music_player.databinding.ItemRecyclerMusictypeCategoryBinding
import com.example.startup_music_player.model.InteFaces.OnClickCategory
import com.example.startup_music_player.model.data.CategoryRespomse
import jp.wasabeef.glide.transformations.BlurTransformation

class CategoryAdapterTypeMusic(private val data: List<CategoryRespomse>, private val onClickCategory: OnClickCategory) : RecyclerView.Adapter<CategoryAdapterTypeMusic.CategoryMusicTypeViewHolder>() {

    inner class CategoryMusicTypeViewHolder(    private var binding: ItemRecyclerMusictypeCategoryBinding
    ) : RecyclerView.ViewHolder(binding.root) {
        fun ViewBinder(dataCategory: CategoryRespomse) {

            binding.txtType.text = dataCategory.typeCategory

            Glide.with(binding.root.context).load(dataCategory.image)
                .apply(RequestOptions.bitmapTransform(BlurTransformation(2, 2)))
                .into(binding.imgCover)

            itemView.setOnClickListener {
                onClickCategory.ClickCategory(dataCategory)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CategoryMusicTypeViewHolder {
        var binding = ItemRecyclerMusictypeCategoryBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return CategoryMusicTypeViewHolder(binding)
    }

    override fun onBindViewHolder(holder: CategoryMusicTypeViewHolder, position: Int) {
        holder.ViewBinder(data[position])
    }

    override fun getItemCount(): Int {
        return data.size
    }
}