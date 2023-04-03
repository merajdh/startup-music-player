package com.example.startup_music_player.ui.features.Artist

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.startup_music_player.R
import com.example.startup_music_player.databinding.FragmentArtistProfileBinding
import com.example.startup_music_player.model.Adapter.ArtistAdapterPopular
import com.example.startup_music_player.model.Adapter.ArtistAdapterRecent
import com.example.startup_music_player.model.Adapter.OnClickArtist
import com.example.startup_music_player.model.Contract.ContractCategory
import com.example.startup_music_player.model.Contract.ContractDetailArtist
import com.example.startup_music_player.model.data.DetailArtistRespomse

import com.example.startup_music_player.model.net.createApiService
import com.example.startup_music_player.model.presenter.PresenterCategory
import com.example.startup_music_player.model.presenter.PresenterDetailArtist
import com.example.startup_music_player.ui.Fragment.ProfileFragment
import com.example.startup_music_player.ui.features.Category.CategoryFragment
import com.example.startup_music_player.ui.features.Home.HomeFragment
import com.example.startup_music_player.ui.features.Play.PlayFragment
import com.example.startup_music_player.util.MyApp
import com.example.startup_music_player.util.NetworkChecker
import com.squareup.picasso.Picasso

class ArtistFragment : Fragment()  , ContractDetailArtist.View , OnClickArtist{

    lateinit var binding : FragmentArtistProfileBinding
    lateinit var presenter: ContractDetailArtist.PresenterArtist

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {
        binding = FragmentArtistProfileBinding.inflate(layoutInflater, container, false)
        setOnClickListener()
        MoreClickListener()
        presenter = PresenterDetailArtist(createApiService(), NetworkChecker(binding.root.context).isInternetConnected)

        lifecycleScope.launchWhenCreated {
            presenter.OnAttach(this@ArtistFragment)

        }
        return binding.root

    }
    private fun setOnClickListener(){
//        moudule One ->

        binding.mouduleOneArtist.btnBack.setOnClickListener {
            parentFragmentManager.popBackStack()
        }

        // moudule Two ->

        binding.mouduleTwoArtist.btnMore.setOnClickListener {
            MyApp.ischeckd = "top_music"
            MoreClickListener()
        }

        // moudule Three ->

        binding.mouduleThreeArtist.btnMore.setOnClickListener {
            MyApp.ischeckd = "new_music"
            MoreClickListener()
        }

    }


    private fun MoreClickListener() {


        when (MyApp.ischeckd) {
            "top_music" -> {
                Toast.makeText(context, "top_music", Toast.LENGTH_SHORT).show()
            }

            "new_music" -> {
                Toast.makeText(context, "new_music", Toast.LENGTH_SHORT).show()
            }

        }
    }

    override fun onDestroy() {
        super.onDestroy()
        val transform = parentFragmentManager.beginTransaction()
        transform.addToBackStack(null)
        transform.replace(R.id.FrameLayout, CategoryFragment())
        transform.commit()
    }

    override fun DetailArtist(data: DetailArtistRespomse) {
        Log.v("loog" , data.popularMusic.toString())

        // set adapter Artist information
        binding.mouduleOneArtist.nameArtist.text = data.name
        binding.mouduleOneArtist.txtAll.text = data.musicQuantity.toString()
        Glide.with(this).load(data.image).into(binding.mouduleOneArtist.ImgArtist)

        // set adapter popular music
        val adapterPopular = ArtistAdapterPopular(data.popularMusic , this)
        binding.mouduleTwoArtist.recPopular.layoutManager = GridLayoutManager(context , 2, RecyclerView.HORIZONTAL , true)
        binding.mouduleTwoArtist.recPopular.adapter = adapterPopular

        // set adapter recent music
        val adapterRecent = ArtistAdapterRecent(data.recentMusic , this)
        binding.mouduleThreeArtist.recRecent.layoutManager = LinearLayoutManager(context, RecyclerView.VERTICAL , false)
        binding.mouduleThreeArtist.recRecent.adapter = adapterRecent

    }

    override fun popularMusic(data: DetailArtistRespomse.PopularMusic) {
        MyApp.idMusic = data.id.toString()
        val transform = parentFragmentManager.beginTransaction()
        transform.replace(R.id.FrameLayoutMain, PlayFragment())
        transform.addToBackStack(null)
        transform.commit()
    }

    override fun recentMusic(data: DetailArtistRespomse.RecentMusic) {
        MyApp.idMusic = data.id.toString()
        val transform = parentFragmentManager.beginTransaction()
        transform.replace(R.id.FrameLayoutMain, PlayFragment())
        transform.addToBackStack(null)
        transform.commit()
    }

}