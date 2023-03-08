package com.example.startup_music_player.ui.features.Play


import android.R
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.example.startup_music_player.databinding.FragmentPlayBinding
import com.example.startup_music_player.ui.Fragment.ProfileFragment
import com.example.startup_music_player.ui.features.Detail.DetaiMusiclFragment
import com.example.startup_music_player.ui.features.Home.HomeFragment
import com.example.startup_music_player.ui.features.playDetail.playDetailFragment
import jp.wasabeef.glide.transformations.BlurTransformation


class PlayFragment : Fragment() {
    lateinit var binding: FragmentPlayBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        binding = FragmentPlayBinding.inflate(layoutInflater, container, false)
        blurImage()

        setOnClickListeners()
        return binding.root

    }

        private fun blurImage() {
            Glide.with(this).load(binding.imgBackground.drawable)
                .apply(RequestOptions.bitmapTransform(BlurTransformation(8, 1)))
                .into(binding.imgBackground)        }


    private fun setOnClickListeners() {

        //music

        // previous ->
        binding.btnPrevious.setOnClickListener {

        }

        //  next ->
        binding.btnNext.setOnClickListener {

        }

        // play ->
        binding.btnPlay.setOnClickListener {

        }

        //another

        // more button  ->
        binding.btnMore.setOnClickListener {
            val transform = DetaiMusiclFragment()
            transform.isCancelable = true
            transform.show(parentFragmentManager , null)
        }

        // like ->
        binding.btnLiked.setOnClickListener {

            if (binding.btnLiked.isChecked){
                //liked ->
            }
            else {
                //disliked - >

            }

        }

        // show more data ->
        binding.btnOpenMore.setOnClickListener {
            val transform = playDetailFragment()
            transform.isCancelable = true
            transform.show(parentFragmentManager, null)
        }

        // back button
        binding.btnBack.setOnClickListener {
            parentFragmentManager.popBackStack()
        }


    }

    override fun onDestroy() {
        super.onDestroy()
        val transform = parentFragmentManager.beginTransaction()
        transform.addToBackStack(null)
        transform.replace(com.example.startup_music_player.R.id.FrameLayout, HomeFragment())
        transform.commit()
    }

}