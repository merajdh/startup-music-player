package com.example.startup_music_player.model.Adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.startup_music_player.databinding.ItemRecyclerInternationalMusicCategoryBinding
import com.example.startup_music_player.model.InteFaces.OnClickHome
import com.example.startup_music_player.model.data.MusicInternatioalRespomse
import com.squareup.picasso.Picasso

class HomeAdapterInternational(
    private val data: List<MusicInternatioalRespomse>,
    private val OnClick: OnClickHome
) : RecyclerView.Adapter<HomeAdapterInternational.HomeInternationalMusicViewHolder>() {

    inner class HomeInternationalMusicViewHolder(private var binding: ItemRecyclerInternationalMusicCategoryBinding
    ) :
        RecyclerView.ViewHolder(binding.root) {
        fun ViewBinder(dataHome: MusicInternatioalRespomse) {

            binding.txtNameMusic.text = dataHome.title
            binding.txtNameSinger.text = dataHome.artist[0]

            Picasso
                .get()
                .load(dataHome.cover)
                .into(binding.imgCover)

            itemView.setOnClickListener {
                OnClick.Click_MusicInternatioal(dataHome)
            }
        }
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): HomeInternationalMusicViewHolder {
        var binding = ItemRecyclerInternationalMusicCategoryBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return HomeInternationalMusicViewHolder(binding)
    }

    override fun onBindViewHolder(holder: HomeInternationalMusicViewHolder, position: Int) {
        holder.ViewBinder(data[position])
    }

    override fun getItemCount(): Int {
        return data.size
    }

}