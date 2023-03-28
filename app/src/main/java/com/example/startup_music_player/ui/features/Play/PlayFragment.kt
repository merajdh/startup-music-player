package com.example.startup_music_player.ui.features.Play

import android.media.MediaPlayer
import android.net.Uri
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.example.startup_music_player.R
import com.example.startup_music_player.databinding.FragmentPlayBinding
import com.example.startup_music_player.model.Contract.ContractPlayMusic
import com.example.startup_music_player.model.data.MusicDetail
import com.example.startup_music_player.model.net.createApiService
import com.example.startup_music_player.model.presenter.PresenterPlayMusic
import com.example.startup_music_player.ui.features.Main.MainFragment
import com.example.startup_music_player.ui.features.playDetail.playDetailFragment
import com.example.startup_music_player.util.NetworkChecker
import com.google.android.material.slider.Slider
import jp.wasabeef.glide.transformations.BlurTransformation
import java.util.*
import kotlin.concurrent.schedule

class PlayFragment : Fragment(), ContractPlayMusic.View {

    lateinit var binding: FragmentPlayBinding
    lateinit var presenter: ContractPlayMusic.Presenter
    lateinit var mediaParser: MediaPlayer
    lateinit var timer: Timer
    var ispluing = false
    var taghir = false
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        binding = FragmentPlayBinding.inflate(layoutInflater, container, false)
        blurImage()
        setOnClickListeners()
        binding.Pliy.setOnClickListener { plymusic() }
        binding.viewMain.visibility = View.GONE
        binding.shimmerPlay.startShimmer()
        presenter = PresenterPlayMusic(createApiService(), NetworkChecker(binding.root.context).isInternetConnected)
        binding.slider.addOnChangeListener { slider, value, fromUser ->

            binding.start.text = converttimemusic(value.toLong())
            taghir = fromUser

        }
        binding.slider.addOnSliderTouchListener(object : Slider.OnSliderTouchListener{
            override fun onStartTrackingTouch(slider: Slider) {

            }

            override fun onStopTrackingTouch(slider: Slider) {
                mediaParser.seekTo(slider.value.toInt())
            }
        })

        lifecycleScope.launchWhenCreated {
            presenter.OnAttach(this@PlayFragment)

        }
        return binding.root

    }

    private fun plymusic() {
        if (ispluing){
            mediaParser.pause()
            binding.ImgPlay.setImageResource(R.drawable.ic_play)
            ispluing = false
        }else{
            mediaParser.start()
            binding.ImgPlay.setImageResource(R.drawable.ic_pause)
            ispluing = true
        }
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
        mediaParser = MediaPlayer.create(binding.root.context, Uri.parse(Music.url))
        mediaParser.start()
        ispluing = true
        binding.ImgPlay.setImageResource(R.drawable.ic_pause)
        binding.slider.valueTo= mediaParser.duration.toFloat()
        binding.taim.text = converttimemusic(mediaParser.duration.toLong())
        mediaParser.isLooping = true
        timer = Timer()
        timer.schedule(1000) {
            binding.slider.value = mediaParser.currentPosition.toFloat()
        }
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
    fun converttimemusic(duration: Long) : String{
        val secend = duration / 1000 % 60
        val minit = duration / (1000 * 60)
        return java.lang.String.format(Locale.US , "%02d:%02d", minit , secend)

    }
}