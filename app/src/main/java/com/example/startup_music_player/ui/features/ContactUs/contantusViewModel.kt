package com.example.startup_music_player.ui.features.ContactUs

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.startup_music_player.model.repository.ticket.ticketrepository
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.launch

class contantusViewModel(private val ticketrepository: ticketrepository):ViewModel() {
    val title = MutableLiveData("")
    val user = MutableLiveData("")
    val body = MutableLiveData("")


    fun sendTicket(TicketEvent: (String) -> Unit) {
        val coroutineExceptionHandler = CoroutineExceptionHandler { _, throwable ->
            Log.v("error", "Error -> " + throwable.message)
        }
        viewModelScope.launch(coroutineExceptionHandler) {
            val result = ticketrepository.SendTicket(body.value!! , user.value!! , title.value!!)
            TicketEvent(result)

        }

    }
}