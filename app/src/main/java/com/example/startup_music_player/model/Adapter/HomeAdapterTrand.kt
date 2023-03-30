package com.example.startup_music_player.model.Adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.example.startup_music_player.R
import com.example.startup_music_player.databinding.ItemRecyclerTrandMusicBinding
import com.example.startup_music_player.model.data.MusicRespomse
import com.squareup.picasso.Picasso

class HomeAdapterTrand (private val data : List<MusicRespomse>,  private val OnClick:OnClickHome) :RecyclerView.Adapter<HomeAdapterTrand.HomeViewHolder>() {
    lateinit var binding:ItemRecyclerTrandMusicBinding

    inner class HomeViewHolder(itemView: View, ) : RecyclerView.ViewHolder(itemView){
        fun ViewBinder (dataHome: MusicRespomse){

            binding.txtNameMusic.text = dataHome.title
            binding.txtNameSinger.text = dataHome.artist[0].toString()
            if (adapterPosition % 2 == 0 ){
                binding.txtNumber.setTextColor(ContextCompat.getColor(binding.root.context , R.color.light_blue))
                binding.backRec.background = ContextCompat.getDrawable(binding.root.context , R.drawable.shape_back_rec_trand)

            }else{
                binding.backRec.background = ContextCompat.getDrawable(binding.root.context , R.drawable.shape_back_rec_trand2)

            }

            Picasso
                .get()
                .load(dataHome.cover)
                .into(binding.imgCover)

            itemView.setOnClickListener {
                OnClick.Click(dataHome)
            }

        }
    } override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HomeAdapterTrand.HomeViewHolder {
        binding = ItemRecyclerTrandMusicBinding.inflate(LayoutInflater.from(parent.context) , parent , false)
        return HomeViewHolder(binding.root)
    }


    override fun onBindViewHolder(holder: HomeAdapterTrand.HomeViewHolder, position: Int) {
        holder.ViewBinder(data[position])
    }

    override fun getItemCount(): Int {
        return data.size
    }



}