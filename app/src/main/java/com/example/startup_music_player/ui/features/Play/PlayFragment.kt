package com.example.startup_music_player.ui.features.Play

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.example.startup_music_player.databinding.FragmentPlayBinding
import com.example.startup_music_player.model.Contract.ContractPlayMusic
import com.example.startup_music_player.model.data.MusicDetail
import com.example.startup_music_player.model.net.createApiService
import com.example.startup_music_player.model.presenter.PresenterPlayMusic
import com.example.startup_music_player.ui.features.playDetail.playDetailFragment
import com.example.startup_music_player.util.NetworkChecker
import jp.wasabeef.glide.transformations.BlurTransformation

class PlayFragment : Fragment(), ContractPlayMusic.View {
    lateinit var binding: FragmentPlayBinding
    lateinit var presenter: ContractPlayMusic.Presenter
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        binding = FragmentPlayBinding.inflate(layoutInflater, container, false)
        blurImage()
        setOnClickListeners()

        binding.viewMain.visibility = View.GONE
        binding.shimmerPlay.startShimmer()
        presenter = PresenterPlayMusic(createApiService(), NetworkChecker(binding.root.context).isInternetConnected)


        lifecycleScope.launchWhenCreated {
            presenter.OnAttach(this@PlayFragment)

        }
        return binding.root

    }


    private fun blurImage() {
        Glide.with(this).load(binding.imgBackground.drawable)
            .apply(RequestOptions.bitmapTransform(BlurTransformation(8, 1)))
            .into(binding.imgBackground)}

    private fun setOnClickListeners() {

        binding.btnOpenMore.setOnClickListener {
            val transform = playDetailFragment()
            transform.isCancelable = true
            transform.show(parentFragmentManager, null)
        }


    }

    override fun PlayMusic(Music: MusicDetail) {

        Glide .with(this).load(Music.cover)
            .into(binding.imgCover)
        Log.v("123" , Music.cover)
        Glide .with(this).load( Music.cover)
            .apply(RequestOptions.bitmapTransform(BlurTransformation(8, 4)))
            .into(binding.imgBackground)

        binding.shimmerPlay.visibility = View.GONE
        binding.viewMain.visibility = View.VISIBLE

        binding.Pliy.text = Music.artist[0].name

        binding.txtNameMusic.text = Music.title
        Log.v("eeee2",Music.toString())
    }

}