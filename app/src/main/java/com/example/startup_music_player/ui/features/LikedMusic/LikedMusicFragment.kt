package com.example.startup_music_player.ui.features.LikedMusic

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.startup_music_player.R
import com.example.startup_music_player.databinding.FragmentLikedMusicBinding
import com.example.startup_music_player.model.Adapter.LikedMusicAdapter
import com.example.startup_music_player.model.Contract.ContractLikeProfile
import com.example.startup_music_player.model.data.MusicRespomse
import com.example.startup_music_player.model.net.createApiService
import com.example.startup_music_player.model.presenter.PresenterLikeProfile
import com.example.startup_music_player.ui.Fragment.ProfileFragment
import com.example.startup_music_player.util.NetworkChecker


class LikedMusicFragment : Fragment() , ContractLikeProfile.View {
    lateinit var binding: FragmentLikedMusicBinding
    lateinit var Presenter: ContractLikeProfile.Presenter
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentLikedMusicBinding.inflate(layoutInflater , container , false)
        setOnClickListener()
        Presenter = PresenterLikeProfile(createApiService(),NetworkChecker(binding.root.context).isInternetConnected,)
        lifecycleScope.launchWhenCreated {
            Presenter.OnAttach(this@LikedMusicFragment)
        }
        return binding.root
    }

    override fun onDestroy() {
        super.onDestroy()
        Presenter.OnDetavh()
        val transform = parentFragmentManager.beginTransaction()
        transform.addToBackStack(null)
        transform.replace(R.id.FrameLayout, ProfileFragment())
        transform.commit()
    }

    private fun setOnClickListener(){
        binding.btnBack.setOnClickListener {
            parentFragmentManager.popBackStack()
        }
    }

    override suspend fun ShowMusicLikeUser(data: List<MusicRespomse>) {
        // setAdapter
        val adapter = LikedMusicAdapter(data)
        binding.recLike.layoutManager = LinearLayoutManager(context , RecyclerView.VERTICAL , false)
        binding.recLike.adapter = adapter
        Log.v("isDatahas", data.toString())
    }

}