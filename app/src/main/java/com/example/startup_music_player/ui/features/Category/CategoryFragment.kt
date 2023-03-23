package com.example.startup_music_player.ui.features.Category

import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.startup_music_player.databinding.FragmentCategoryBinding
import com.example.startup_music_player.model.Adapter.CategoryAdapterTypeMusic
import com.example.startup_music_player.model.Adapter.HomeAdapterHappyMusic
import com.example.startup_music_player.model.Adapter.OnClickCategory
import com.example.startup_music_player.model.Adapter.OnClickHome
import com.example.startup_music_player.model.Contract.ContractCategory
import com.example.startup_music_player.model.data.CategoryRespomse
import com.example.startup_music_player.model.myApp.myApp
import com.example.startup_music_player.model.net.createApiService
import com.example.startup_music_player.model.presenter.PresenterCategory
import com.example.startup_music_player.model.presenter.PresenterPlayMusic
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
        presenter = PresenterCategory(createApiService(), NetworkChecker(binding.root.context).isInternetConnected)

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
            myApp.ischeckd = "category_music"
            MoreClickListener()
        }

        //moudule One ->

        binding.mouduleTwoCategory.btnMore.setOnClickListener {
            myApp.ischeckd = "artist"
            MoreClickListener()
        }

    }

    private fun MoreClickListener() {

        when (myApp.ischeckd) {
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

    override fun ClickCategory(data: CategoryRespomse) {

    }

}