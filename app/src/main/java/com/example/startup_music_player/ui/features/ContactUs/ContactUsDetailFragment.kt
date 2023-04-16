package com.example.startup_music_player.ui.features.ContactUs

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModel
import com.example.startup_music_player.R
import com.example.startup_music_player.databinding.FragmentContactUsDetailBinding
import com.example.startup_music_player.model.repository.TokenInMemory
import com.example.startup_music_player.util.MyApp
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import ir.dunijet.dunibazaar.util.VALUE_SUCCESS
import org.koin.androidx.viewmodel.ext.android.viewModel

class ContactUsDetailFragment : BottomSheetDialogFragment() {
    lateinit var binding:FragmentContactUsDetailBinding
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding  = FragmentContactUsDetailBinding.inflate(layoutInflater , container , false)
        setOnClickListeners()
        return binding.root
    }

    private fun setOnClickListeners(){
        binding.btnCancel.setOnClickListener { dismiss() }

        binding.btnAccept.setOnClickListener {
            val viewModel : contantusViewModel by viewModel()
            viewModel.id.value = MyApp.idTicket
            viewModel.username.value = TokenInMemory.username
            viewModel.ditail.value = binding.txtTicket.text.toString()
            viewModel.sendTicket {
                if (it == VALUE_SUCCESS){

                }else{

                }
            }
        }
    }

    override fun getTheme() = R.style.RoundedCornersBottomSheetDialog


}