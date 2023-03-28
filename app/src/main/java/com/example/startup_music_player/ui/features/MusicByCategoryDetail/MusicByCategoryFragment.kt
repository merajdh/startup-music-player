package com.example.startup_music_player.ui.features.MusicByCategoryDetail

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.example.startup_music_player.R
import com.example.startup_music_player.databinding.FragmentMusicbycategoryDetailBinding
import com.example.startup_music_player.model.Adapter.MusicByCategoryAdapter
import com.example.startup_music_player.model.Adapter.OnClickMusicByCategory
import com.example.startup_music_player.model.Contract.ContractDetailMusicByCategory
import com.example.startup_music_player.model.data.MusicByCategoryData
import com.example.startup_music_player.model.net.createApiService
import com.example.startup_music_player.model.presenter.PresenterDetailMusicByCategory
import com.example.startup_music_player.ui.features.Artist.ArtistFragment
import com.example.startup_music_player.ui.features.Category.CategoryFragment
import com.example.startup_music_player.ui.features.Play.PlayFragment
import com.example.startup_music_player.util.MyApp
import com.example.startup_music_player.util.NetworkChecker
import com.squareup.picasso.Picasso
import jp.wasabeef.glide.transformations.BlurTransformation


class MusicByCategoryFragment  : Fragment() , ContractDetailMusicByCategory.View , OnClickMusicByCategory{
    lateinit var binding: FragmentMusicbycategoryDetailBinding
    lateinit var presenter: ContractDetailMusicByCategory.PresenterMusicByCategory


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        binding = FragmentMusicbycategoryDetailBinding.inflate(layoutInflater,container,false)
        Bundledata()
        presenter = PresenterDetailMusicByCategory(createApiService(), NetworkChecker(binding.root.context).isInternetConnected)


        lifecycleScope.launchWhenCreated {
            presenter.OnAttach(this@MusicByCategoryFragment)

        }
        return binding.root
    }

    private fun Bundledata(){
        val bundle = arguments
        if (bundle != null){
            val text = bundle.getString("type")
            binding.txtCategory.text = text

            val img = bundle.getString("img")
            Glide.with(binding.root).load(img).into(binding.imgBackground)
        }
    }

    override fun MusicByCategory(data: List<MusicByCategoryData>) {
        Log.v("testet", data.toString())

        val adapter = MusicByCategoryAdapter(data, this)
        binding.recMusicByCategory.layoutManager =
            GridLayoutManager(context, 1, RecyclerView.VERTICAL, true)
        binding.recMusicByCategory.adapter = adapter

    }


    override fun onDestroy() {
        super.onDestroy()
        val transform = parentFragmentManager.beginTransaction()
        transform.addToBackStack(null)
        transform.replace(R.id.FrameLayout, CategoryFragment())
        transform.commit()
    }

    override fun onClickMusicByCategory(data: MusicByCategoryData) {

        MyApp.idMusic = data.id.toString()
        val transform = parentFragmentManager.beginTransaction()
        transform.replace(R.id.FrameLayoutMain, PlayFragment())
        transform.addToBackStack(null)
        transform.commit()
    }

}