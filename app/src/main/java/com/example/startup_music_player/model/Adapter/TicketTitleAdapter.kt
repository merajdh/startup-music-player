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
    lateinit var binding: ItemRecyclerContactUsBinding

    inner class TicketTitleViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun ViewBinder(ticket: TitleTicket) {
            binding.txtTitle.text = ticket.title
            itemView.setOnClickListener {
                onClickTitleTicket.onClickTicketTitle(ticket)
            }
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TicketTitleViewHolder {
        binding = ItemRecyclerContactUsBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return TicketTitleViewHolder(binding.root)
    }

    override fun onBindViewHolder(holder: TicketTitleViewHolder, position: Int) {
        holder.ViewBinder(data[position])
    }

    override fun getItemCount(): Int {
        return data.size
    }
}