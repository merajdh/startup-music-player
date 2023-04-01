package com.example.startup_music_player.ui.features.ContactUs

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.startup_music_player.databinding.FragmentContactUsBinding
import com.example.startup_music_player.model.InteFaces.OnClickConteactUs

class ContactUsFragment : Fragment() , OnClickConteactUs {
    lateinit var binding:FragmentContactUsBinding
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = FragmentContactUsBinding.inflate(layoutInflater , container , false)

        return binding.root
    }

    override fun onClick() {
        val transform = ContactUsBottomSheet()
        transform.isCancelable = true
        transform.show(childFragmentManager , null)
    }
}