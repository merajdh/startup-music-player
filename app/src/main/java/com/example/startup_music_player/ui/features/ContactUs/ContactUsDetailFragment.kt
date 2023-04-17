package com.example.startup_music_player.ui.features.ContactUs

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.startup_music_player.R
import com.example.startup_music_player.databinding.FragmentContactUsDetailBinding
import com.example.startup_music_player.model.repository.TokenInMemory
import com.example.startup_music_player.ui.Fragment.ProfileFragment
import com.example.startup_music_player.util.MyApp
import ir.dunijet.dunibazaar.util.VALUE_SUCCESS
import org.koin.androidx.viewmodel.ext.android.viewModel

class ContactUsDetailFragment : Fragment() {
    lateinit var binding:FragmentContactUsDetailBinding
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding  = FragmentContactUsDetailBinding.inflate(layoutInflater , container , false)
        setOnClickListeners()
        return binding.root
    }

    private fun setOnClickListeners(){

        binding.btnAccept.setOnClickListener {
            val viewModel : contantusViewModel by viewModel()
            viewModel.title.value = MyApp.idTicket
            viewModel.user.value = TokenInMemory.userid
            viewModel.body.value = binding.txtTicket.text.toString()
            viewModel.sendTicket {
                Log.v("isSend" , it)
                if (it == VALUE_SUCCESS){
                    Log.v("isSend" , "haha")

                }else{

                }
            }
        }
    }



}