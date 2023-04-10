package com.example.startup_music_player.ui.features.Serach

import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.widget.addTextChangedListener
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import com.example.startup_music_player.R
import com.example.startup_music_player.databinding.FragmentSearchBinding
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
        presenter = PresenterSrech(createApiService(),NetworkChecker(binding.root.context).isInternetConnected)
        binding.imgSreach.setOnClickListener {
            MyApp.musicserch = binding.EdtSearch.text.toString()
            search()
        }
        return inflater.inflate(R.layout.fragment_search, container, false)
    }

    private fun search() {
        // visibel anim loding >


        //serach ->
        lifecycleScope.launchWhenCreated {
            presenter.OnAttach(this@SearchFragment)
        }
    }

    private fun setOnClickListeners() {

        binding.swipeSearch.setOnRefreshListener {
            // load data hare

            Handler(Looper.getMainLooper()).postDelayed({
                binding.swipeSearch.isRefreshing = false

            }, 800)
        }
    }

    override fun srech(data: List<MusicRespomse>) {
        // invisibel anim loding >

        // set adapter
    }

}
