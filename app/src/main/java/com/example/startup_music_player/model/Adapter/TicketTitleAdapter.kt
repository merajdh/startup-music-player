package com.example.startup_music_player.model.Adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.startup_music_player.databinding.ItemRecyclerContactUsBinding
import com.example.startup_music_player.model.InteFaces.OnClickTicketTitle
import com.example.startup_music_player.model.data.TitleTicket


class TicketTitleAdapter(private val data: List<TitleTicket>, private val onClickTitleTicket: OnClickTicketTitle ) :
    RecyclerView.Adapter<TicketTitleAdapter.TicketTitleViewHolder>() {

    inner class TicketTitleViewHolder(private var binding: ItemRecyclerContactUsBinding
    ) : RecyclerView.ViewHolder(binding.root) {
        fun ViewBinder(ticket: TitleTicket) {
            binding.txtTitle.text = ticket.title
            itemView.setOnClickListener {
                onClickTitleTicket.onClickTicketTitle(ticket)
            }
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TicketTitleViewHolder {
        var binding = ItemRecyclerContactUsBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return TicketTitleViewHolder(binding)
    }

    override fun onBindViewHolder(holder: TicketTitleViewHolder, position: Int) {
        holder.ViewBinder(data[position])
    }

    override fun getItemCount(): Int {
        return data.size
    }
}