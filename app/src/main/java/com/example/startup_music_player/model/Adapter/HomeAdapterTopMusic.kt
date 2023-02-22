package com.example.startup_music_player.model.Adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.startup_music_player.databinding.ItemRecyclerTopMusicHomeBinding
import com.example.startup_music_player.model.data.MusicRespomse
import com.squareup.picasso.Picasso

class HomeAdapterTopMusic(private val data : ArrayList<MusicRespomse>,  private val OnClick:OnClick) :RecyclerView.Adapter<HomeAdapterTopMusic.HomeViewHolder>() {
    lateinit var binding:ItemRecyclerTopMusicHomeBinding

        inner class HomeViewHolder(itemView: View, ) : RecyclerView.ViewHolder(itemView){
            fun ViewBinder (dataHome: MusicRespomse){
                binding.txtNameMusic.text = dataHome.NameMusic
                binding.txtNameSinger.text = dataHome.NAmeArtist
                Picasso
                    .get()
                    .load(dataHome.Cover)
                    .into(binding.imgCover)

                itemView.setOnClickListener {
                    OnClick.Click(dataHome)
                }

            }
        }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HomeViewHolder {
        binding = ItemRecyclerTopMusicHomeBinding.inflate(LayoutInflater.from(parent.context) , parent , false)
        return HomeViewHolder(binding.root)
    }

    override fun onBindViewHolder(holder: HomeViewHolder, position: Int) {
        holder.ViewBinder(data[position])
    }

    override fun getItemCount(): Int {
        return data.size
    }


}