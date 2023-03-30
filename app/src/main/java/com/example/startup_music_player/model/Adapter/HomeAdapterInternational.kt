package com.example.startup_music_player.model.Adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.startup_music_player.databinding.ItemRecyclerInternationalMusicCategoryBinding
import com.example.startup_music_player.model.data.MusicRespomse
import com.squareup.picasso.Picasso

class HomeAdapterInternational(
    private val data: List<MusicRespomse>,
    private val OnClick: OnClickHome
) : RecyclerView.Adapter<HomeAdapterInternational.HomeInternationalMusicViewHolder>() {
    lateinit var binding: ItemRecyclerInternationalMusicCategoryBinding

    inner class HomeInternationalMusicViewHolder(itemView: View) :
        RecyclerView.ViewHolder(itemView) {
        fun ViewBinder(dataHome: MusicRespomse) {

            binding.txtNameMusic.text = dataHome.title
            binding.txtNameSinger.text = dataHome.artist[0]

            Picasso
                .get()
                .load(dataHome.cover)
                .into(binding.imgCover)

            itemView.setOnClickListener {
                OnClick.Click(dataHome)
            }
        }
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): HomeInternationalMusicViewHolder {
        binding = ItemRecyclerInternationalMusicCategoryBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return HomeInternationalMusicViewHolder(binding.root)
    }

    override fun onBindViewHolder(holder: HomeInternationalMusicViewHolder, position: Int) {
        holder.ViewBinder(data[position])
    }

    override fun getItemCount(): Int {
        return data.size
    }

}