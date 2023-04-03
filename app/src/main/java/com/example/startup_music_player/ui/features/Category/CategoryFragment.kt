package com.example.startup_music_player.ui.features.Category

import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.startup_music_player.R
import com.example.startup_music_player.databinding.FragmentCategoryBinding
import com.example.startup_music_player.model.Adapter.*
import com.example.startup_music_player.model.Contract.ContractCategory
import com.example.startup_music_player.model.InteFaces.OnClickCategory
import com.example.startup_music_player.model.data.ListArtistData
import com.example.startup_music_player.model.data.CategoryRespomse
import com.example.startup_music_player.model.db.AppDatabase
import com.example.startup_music_player.model.net.createApiService
import com.example.startup_music_player.model.presenter.PresenterCategory
import com.example.startup_music_player.ui.features.Artist.ArtistFragment
import com.example.startup_music_player.ui.features.MusicByCategoryDetail.MusicByCategoryFragment
import com.example.startup_music_player.util.MyApp
import com.example.startup_music_player.util.NetworkChecker

class CategoryFragment : Fragment() , ContractCategory.View , OnClickCategory {
    lateinit var binding: FragmentCategoryBinding
    lateinit var presenter: ContractCategory.PresenterCategory

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        binding = FragmentCategoryBinding.inflate(layoutInflater,container,false)
        setOnClickListeners()
        MoreClickListener()
        presenter = PresenterCategory(createApiService(), NetworkChecker(binding.root.context).isInternetConnected,AppDatabase.getDatabes(binding.root.context).Category,AppDatabase.getDatabes(binding.root.context).Artist)

        lifecycleScope.launchWhenCreated {
            presenter.OnAttach(this@CategoryFragment)
        }


        return binding.root
    }

    private fun setOnClickListeners(){

        binding.swipeCategory.setOnRefreshListener {
            // load data hare

            Handler (Looper.getMainLooper()).postDelayed({
                binding.swipeCategory.isRefreshing = false

            },800)
        }

        //moudule Two ->

        binding.mouduleTwoCategory.btnMore.setOnClickListener {
            MyApp.ischeckd = "category_music"
            MoreClickListener()
        }

        //moudule One ->

        binding.mouduleTwoCategory.btnMore.setOnClickListener {
            MyApp.ischeckd = "artist"
            MoreClickListener()
        }

    }

    private fun MoreClickListener() {

        when (MyApp.ischeckd) {
            "category_music" -> {
                Toast.makeText(context, "category_music", Toast.LENGTH_SHORT).show()
            }

            "artist" -> {
                Toast.makeText(context, "artist", Toast.LENGTH_SHORT).show()
            }

            "international" -> {
                Toast.makeText(context, "international", Toast.LENGTH_SHORT).show()
            }

        }
    }

    override fun TypeOfMusic(data: List<CategoryRespomse>) {

        val adapter = CategoryAdapterTypeMusic(data,this)
        binding.mouduleOneCategory.recType.layoutManager =
            GridLayoutManager(context, 2, RecyclerView.VERTICAL, false)
        binding.mouduleOneCategory.recType.adapter = adapter

    }

    override fun ListArtist(data: List<ListArtistData>) {
        val adapter = CategoryAdapterArtist(data,this)
        binding.mouduleTwoCategory.recArtist.layoutManager =
            GridLayoutManager(context, 1, RecyclerView.HORIZONTAL, true)
        binding.mouduleTwoCategory.recArtist.adapter = adapter

    }

    override fun ClickCategory(data: CategoryRespomse) {
        MyApp.idCategory = data.id
        val image = data.cover
        val type = data.typeCategory
        val bundle = Bundle()
        bundle.putString("img" , image)
        bundle.putString("type" , type)
        val fragment = MusicByCategoryFragment()
        fragment.arguments = bundle
        Log.v("img", data.typeCategory)
        val transform = parentFragmentManager.beginTransaction()
        transform.replace(R.id.FrameLayoutMain, fragment)
        transform.addToBackStack(null)
        transform.commit()

    }

    override fun OnClickArtist(data: ListArtistData) {
        MyApp.idArtist = data.id.toString()
        val transform = parentFragmentManager.beginTransaction()
        transform.replace(R.id.FrameLayoutMain, ArtistFragment())
        transform.addToBackStack(null)
        transform.commit()
    }



}