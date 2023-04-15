package com.example.startup_music_player.ui.features.Serach

import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.util.Log
import android.view.KeyEvent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.widget.addTextChangedListener
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.startup_music_player.R
import com.example.startup_music_player.databinding.FragmentSearchBinding
import com.example.startup_music_player.model.Adapter.SearchAdapter
import com.example.startup_music_player.model.Contract.ContractSrech
import com.example.startup_music_player.model.data.MusicRespomse
import com.example.startup_music_player.model.net.createApiService
import com.example.startup_music_player.model.presenter.PresenterSrech
import com.example.startup_music_player.util.MyApp
import com.example.startup_music_player.util.NetworkChecker


class SearchFragment : Fragment(),ContractSrech.View {

    lateinit var binding: FragmentSearchBinding
    lateinit var presenter : ContractSrech.PresenterSrech
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentSearchBinding.inflate(layoutInflater, container, false)
        setOnClickListeners()
        EnterPresed()

        presenter = PresenterSrech(createApiService(),NetworkChecker(binding.root.context).isInternetConnected)
        binding.imgSreach.setOnClickListener {
            MyApp.musicserch = binding.EdtSearch.text.toString()
            search()
        }
        return binding.root
    }

    private fun EnterPresed() {
        binding.EdtSearch.setOnKeyListener(View.OnKeyListener { v, keyCode, event ->
            // Check if the key event was a key-up event and if it was the spacebar
            if (keyCode == KeyEvent.KEYCODE_ENTER) {
                // Initiate search
                MyApp.musicserch = binding.EdtSearch.text.toString()
                search()
                return@OnKeyListener true
            }
            return@OnKeyListener false
        })
    }

    private fun search() {
        // visibel anim loding >
        binding.animLoading.visibility = View.VISIBLE
        binding.animLoading.playAnimation()
        //serach ->

        lifecycleScope.launchWhenCreated {
            presenter.OnAttach(this@SearchFragment)
        }
    }

    private fun setOnClickListeners() {

    }

    override fun srech(data: List<MusicRespomse>) {
        // invisibel anim loding >
        binding.animLoading.visibility = View.GONE

            // set adapter
        if (binding.EdtSearch.text.isNotEmpty()){
            val adapter = SearchAdapter(data)
            binding.rclSrech.adapter = adapter
            binding.rclSrech.layoutManager =
                LinearLayoutManager(context, RecyclerView.VERTICAL, false)
        }




    }

}
