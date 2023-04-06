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
import com.example.startup_music_player.databinding.FragmentPlayTestBinding
import com.example.startup_music_player.model.Contract.ContractPlayMusic
import com.example.startup_music_player.model.data.MusicDetail
import com.example.startup_music_player.model.net.createApiService
import com.example.startup_music_player.model.presenter.PresenterPlayMusic
import com.example.startup_music_player.ui.features.playDetail.playDetailFragment
import com.example.startup_music_player.util.MyApp
import com.example.startup_music_player.util.NetworkChecker
import com.google.android.material.slider.Slider
import ir.dunijet.dunibazaar.util.VALUE_SUCCESS
import jp.wasabeef.glide.transformations.BlurTransformation
import org.koin.androidx.viewmodel.ext.android.viewModel
import java.util.*

class PlayFragment : Fragment(), ContractPlayMusic.View {

    lateinit var binding: FragmentPlayTestBinding
    lateinit var presenter: ContractPlayMusic.Presenter
    private var mediaplayer :MediaPlayer? = null
    lateinit var timer: Timer
    var taghir: Boolean? = null
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        binding = FragmentPlayTestBinding.inflate(layoutInflater, container, false)
        blurImage()
        setOnClickListeners()
        binding.mouduleOnePlay.LikeMusic.setOnClickListener { addLike() }
        binding.mouduleOnePlay.Pliy.setOnClickListener { plymusic() }
        presenter = PresenterPlayMusic(
            createApiService(),
            NetworkChecker(binding.root.context).isInternetConnected
        )
        binding.mouduleOnePlay.slider.addOnChangeListener { slider, value, fromUser ->

            binding.mouduleOnePlay.start.text = converttimemusic(value.toLong())
            taghir = fromUser

        }
        binding.mouduleOnePlay.slider.addOnSliderTouchListener(object :
            Slider.OnSliderTouchListener {
            override fun onStartTrackingTouch(slider: Slider) {

            }

            override fun onStopTrackingTouch(slider: Slider) {
                mediaplayer?.seekTo(slider.value.toInt())

            }
        })

        lifecycleScope.launchWhenCreated {
            presenter.OnAttach(this@PlayFragment)

        }
        return binding.root

    }

    private fun plymusic() {
        if (MyApp.ispluing) {
            mediaplayer?.pause()
            binding.mouduleOnePlay.Pliy.setImageResource(R.drawable.ic_play)
            MyApp.ispluing = false
        } else {
            mediaplayer?.start()
            binding.mouduleOnePlay.Pliy.setImageResource(R.drawable.ic_pause)
            MyApp.ispluing = true
        }
    }
    fun prepareMusik(data : MusicDetail){
        if (mediaplayer != null){
            mediaplayer?.stop()
            mediaplayer?.release()
            mediaplayer = null
        }
        mediaplayer = MediaPlayer.create(binding.root.context, Uri.parse(data.url))
        mediaplayer?.start()


        MyApp.ispluing = true
        binding.mouduleOnePlay.Pliy.setImageResource(R.drawable.ic_pause)
        binding.mouduleOnePlay.slider.valueTo = mediaplayer?.duration!!.toFloat()
        binding.mouduleOnePlay.taim.text = converttimemusic(mediaplayer?.duration!!.toLong())
        mediaplayer?.isLooping = true
        timer = Timer()

        timer.schedule(object : TimerTask() {
            override fun run() {
                activity?.runOnUiThread {
                    binding.mouduleOnePlay.slider.value = mediaplayer?.currentPosition!!.toFloat()
                    binding.mouduleOnePlay.slider.value.toString()
                }
            }
        }, 1000, 1000)
    }

    private fun blurImage() {
        Glide.with(this).load(binding.mouduleOnePlay.imgBackground.drawable)
            .apply(RequestOptions.bitmapTransform(BlurTransformation(8, 1)))
            .into(binding.mouduleOnePlay.imgBackground)
    }

    private fun setOnClickListeners() {

        binding.mouduleOnePlay.btnOpenMore.setOnClickListener {
            val transform = playDetailFragment()
            transform.isCancelable = true
            transform.show(parentFragmentManager, null)
        }
    }

    override fun PlayMusic(Music: MusicDetail) {
        prepareMusik(Music)
        Glide.with(this).load(Music.cover)
            .into(binding.mouduleOnePlay.imgCover)
        Glide.with(this).load(Music.cover)
            .apply(RequestOptions.bitmapTransform(BlurTransformation(8, 4)))
            .into(binding.mouduleOnePlay.imgBackground)
        binding.mouduleOnePlay.artistName.text = Music.artist[0].name
        binding.mouduleOnePlay.txtNameMusic.text = Music.title
    }

    fun converttimemusic(duration: Long): String {
        val secend = duration / 1000 % 60
        val minit = duration / (1000 * 60)
        return java.lang.String.format(Locale.US, "%02d:%02d", minit, secend)

    }

    fun addLike() {
        val viewmodel: LikeViewModel by viewModel()
        viewmodel.pk.value = MyApp.idMusic
        viewmodel.LikeMusic {

            if (it == VALUE_SUCCESS) {
                //Show
            } else {
                //
            }
        }
    }
}