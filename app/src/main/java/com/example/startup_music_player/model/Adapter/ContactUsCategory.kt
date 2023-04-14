package com.example.startup_music_player.model.Adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.startup_music_player.databinding.ItemRecyclerContactUsBinding
import com.example.startup_music_player.model.InteFaces.OnClickConteactUs
import com.example.startup_music_player.model.data.MusicRespomse


class ContactUsCategory(
    private val data: List<MusicRespomse>,
    private val onClickConteactUs: OnClickConteactUs
) :
    RecyclerView.Adapter<ContactUsCategory.ContactUsCategoryViewHolder>() {


    inner class ContactUsCategoryViewHolder(private var binding: ItemRecyclerContactUsBinding) : RecyclerView.ViewHolder(binding.root) {
        fun ViewBinder(data: MusicRespomse) {

            itemView.setOnClickListener {
                onClickConteactUs.onClick()
            }
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ContactUsCategoryViewHolder {
        var binding = ItemRecyclerContactUsBinding.inflate(
            LayoutInflater.from(parent.context), parent, false
        )
        return ContactUsCategoryViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ContactUsCategoryViewHolder, position: Int) {
        holder.ViewBinder(data[position])
    }

    override fun getItemCount(): Int {
        return data.size
    }
}