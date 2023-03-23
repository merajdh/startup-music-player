package com.example.startup_music_player.ui.features.Play

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.example.startup_music_player.databinding.FragmentPlayBinding
import com.example.startup_music_player.model.Contract.ContractPlayMusic
import com.example.startup_music_player.model.data.MusicDetail
import com.example.startup_music_player.model.data.MusicRespomse
import com.example.startup_music_player.model.net.createApiService
import com.example.startup_music_player.model.presenter.PresenterPlayMusic
import com.example.startup_music_player.ui.features.playDetail.playDetailFragment
import com.example.startup_music_player.util.NetworkChecker
import com.squareup.picasso.Picasso
import ir.dunijet.dunibazaar.util.BASE_URL
import jp.wasabeef.glide.transformations.BlurTransformation

const val BASE_URL_IMAGE = "https://abolfazlzzx13.pythonanywhere.com/"
class PlayFragment : Fragment(), ContractPlayMusic.View {
    lateinit var binding: FragmentPlayBinding
    lateinit var presenter: ContractPlayMusic.Presenter
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        binding = FragmentPlayBinding.inflate(layoutInflater, container, false)
        setOnClickListeners()
        presenter = PresenterPlayMusic(createApiService(), NetworkChecker(binding.root.context).isInternetConnected)


        lifecycleScope.launchWhenCreated {
            presenter.OnAttach(this@PlayFragment)

        }
        return binding.root

    }


    private fun blurImage(view: ImageView) {
        Glide.with(this).load(binding.imgBackground.drawable)
            .apply(RequestOptions.bitmapTransform(BlurTransformation(8, 1)))
            .into(view)
    }

    private fun setOnClickListeners() {

        binding.btnOpenMore.setOnClickListener {
            val transform = playDetailFragment()
            transform.isCancelable = true
            transform.show(parentFragmentManager, null)
        }


    }

    override fun PlayMusic(Music: MusicDetail) {
        val url =
            "https://dkstatics-public.digikala.com/digikala-products/fb3e51269c9931fc223047e2a9b063d54224e6f0_1651833531.jpg?x-oss-process=image/resize,m_lfit,h_800,w_800/quality,q_90"

        Glide .with(this).load(BASE_URL_IMAGE + Music.cover)
            .into(binding.imgCover)

        Log.v("123" , Music.cover)
        Glide .with(this).load(BASE_URL_IMAGE + Music.cover)
            .apply(RequestOptions.bitmapTransform(BlurTransformation(8, 4)))
            .into(binding.imgBackground)


        binding.Pliy.text = Music.artist[0].name

        binding.txtNameMusic.text = Music.title

    }

}