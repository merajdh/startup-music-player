package com.example.startup_music_player.ui.features.Home

import android.annotation.SuppressLint
import android.content.Context
import android.content.SharedPreferences
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
import com.denzcoskun.imageslider.constants.ScaleTypes
import com.denzcoskun.imageslider.interfaces.ItemClickListener
import com.denzcoskun.imageslider.models.SlideModel
import com.example.startup_music_player.R
import com.example.startup_music_player.databinding.FragmentHomeBinding
import com.example.startup_music_player.model.Adapter.*
import com.example.startup_music_player.model.Contract.ContractHome
import com.example.startup_music_player.model.data.MusicRespomse
import com.example.startup_music_player.model.db.AppDatabase
import com.example.startup_music_player.model.db.MusicByCategoryDao
import com.example.startup_music_player.model.myApp.myApp
import com.example.startup_music_player.model.net.createApiService
import com.example.startup_music_player.model.presenter.PresenterHome
import com.example.startup_music_player.ui.features.Play.PlayFragment
import com.example.startup_music_player.util.MyApp
import com.example.startup_music_player.util.NetworkChecker


class HomeFragment : Fragment(), ContractHome.View, OnClickHome {
    lateinit var binding: FragmentHomeBinding
    lateinit var presenter: ContractHome.Presenter
    lateinit var musicByCategoryDao: MusicByCategoryDao
    lateinit var sharedPreferences: SharedPreferences

    @SuppressLint("CommitPrefEdits")
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        binding = FragmentHomeBinding.inflate(layoutInflater, container, false)

        sharedPreferences =
            binding.root.context.getSharedPreferences("dataSend", Context.MODE_PRIVATE)
        sharedPreferences.edit().putBoolean("dataSend", MyApp.isSend).apply()
        AddsliderCod() // slider
        val dataSend = sharedPreferences.getBoolean("dataSend", false)
        when (MyApp.isSend) {
            MyApp.isSend == true -> {
                binding.shimmerHome.visibility = View.GONE
            }
            else -> {
                binding.shimmerHome.visibility = View.VISIBLE
            }
        }

        setOnClickListeners()
        MoreClickListener()
        presenter = PresenterHome(
            createApiService(),
            NetworkChecker(binding.root.context).isInternetConnected,
            AppDatabase.getDatabes(binding.root.context).MusicByCategoryDao
        )

        lifecycleScope.launchWhenCreated {
            presenter.OnAttach(this@HomeFragment)

        }


        binding.mouduleOneHome.slider.setItemClickListener(object : ItemClickListener {
            override fun onItemSelected(position: Int) {
                when (position) {
                    0 -> {
                        Log.v("test", "0")
                    }
                    1 -> {
                        Log.v("test", "1")
                    }
                    2 -> {
                        Log.v("test", "3")
                    }
                }
            }
        })

        return binding.root
    }

    fun AddsliderCod() {
        val ItemSlider = ArrayList<SlideModel>()
        ItemSlider.add(
            SlideModel(
                "https://images.hdqwalls.com/download/eminem-rapper-wallpaper-2560x1440.jpg",
                ScaleTypes.FIT
            )
        )
        ItemSlider.add(SlideModel("https://images4.alphacoders.com/193/193108.jpg", ScaleTypes.FIT))
        ItemSlider.add(SlideModel("https://wallpaper.dog/large/17006205.jpg", ScaleTypes.FIT))
        binding.mouduleOneHome.slider.setImageList(ItemSlider)

    }


    // set data Adapter Ofline
    override fun MusicByCategoryOf(data: List<MusicRespomse>) {

        val adapter = HomeAdapterHappyMusic(data, this)
        binding.mouduleOneHome.recHappyMusic.layoutManager =
            GridLayoutManager(context, 1, RecyclerView.HORIZONTAL, true)
        binding.mouduleOneHome.recHappyMusic.adapter = adapter
    }

    override fun MoreLikeOf(data: List<MusicRespomse>) {
        val adapter = HomeAdapterTopMusic(data, this)
        binding.mouduleTwoHome.recTopMusic.layoutManager =
            GridLayoutManager(context, 2, RecyclerView.HORIZONTAL, true)
        binding.mouduleTwoHome.recTopMusic.adapter = adapter
    }

    override fun RecentMusikOf(data: List<MusicRespomse>) {
        val adapter = HomeAdapterTopMusic(data, this)
        binding.mouduleThreeHome.recNewMusic.layoutManager =
            GridLayoutManager(context, 1, RecyclerView.VERTICAL, false)
        binding.mouduleThreeHome.recNewMusic.adapter = adapter
    }

    override fun TrendMusikOf(data: List<MusicRespomse>) {

        val adapter = HomeAdapterTrand(data, this)
        binding.mouduleFourHome.recTrandMusic.layoutManager =
            GridLayoutManager(context, 1, RecyclerView.VERTICAL, false)
        binding.mouduleFourHome.recTrandMusic.adapter = adapter
    }

    override fun InternationalMusicOf(data: List<MusicRespomse>) {
        val adapter = HomeAdapterInternational(data, this)
        binding.mouduleFourHome.recTrandMusic.layoutManager =
            GridLayoutManager(context, 1, RecyclerView.VERTICAL, false)
        binding.mouduleFourHome.recTrandMusic.adapter = adapter

    }


    // set data Adapter Online
    override fun MusicByCategoryOn(data: List<MusicRespomse>) {
        binding.shimmerHome.visibility = View.GONE


        val adapter = HomeAdapterHappyMusic(data, this)
        binding.mouduleOneHome.recHappyMusic.layoutManager =
            GridLayoutManager(context, 1, RecyclerView.HORIZONTAL, true)
        binding.mouduleOneHome.recHappyMusic.adapter = adapter

    }

    override fun MoreLikeOn(data: List<MusicRespomse>) {

        val adapter = HomeAdapterTopMusic(data, this)
        binding.mouduleTwoHome.recTopMusic.layoutManager =
            GridLayoutManager(context, 2, RecyclerView.HORIZONTAL, true)
        binding.mouduleTwoHome.recTopMusic.adapter = adapter
    }

    override fun RecentMusikOn(data: List<MusicRespomse>) {

        val adapter = HomeAdapterTopMusic(data, this)
        binding.mouduleThreeHome.recNewMusic.layoutManager =
            GridLayoutManager(context, 1, RecyclerView.VERTICAL, false)
        binding.mouduleThreeHome.recNewMusic.adapter = adapter


    }

    override fun TrendMusikOn(data: List<MusicRespomse>) {

        val adapter = HomeAdapterTrand(data, this)
        binding.mouduleFourHome.recTrandMusic.layoutManager =
            GridLayoutManager(context, 1, RecyclerView.VERTICAL, false)
        binding.mouduleFourHome.recTrandMusic.adapter = adapter

    }

    override fun InternationalMusicOn(data: List<MusicRespomse>) {

        val adapter = HomeAdapterInternational(data, this)
        binding.mouduleFourHome.recTrandMusic.layoutManager =
            GridLayoutManager(context, 1, RecyclerView.VERTICAL, false)
        binding.mouduleFourHome.recTrandMusic.adapter = adapter

    }

    override fun Click(data: MusicRespomse) {
        MyApp.idMusic = data.id.toString()
        val transform = parentFragmentManager.beginTransaction()
        transform.replace(R.id.FrameLayoutMain, PlayFragment())
        transform.addToBackStack(null)
        transform.commit()
        //test interface
        Toast.makeText(context, data.title, Toast.LENGTH_SHORT).show()
    }

    fun setOnClickListeners() {

        binding.mouduleOneHome.btnMore.setOnClickListener {
            myApp.ischeckd = "happy_music"
            MoreClickListener()
        }

        binding.mouduleTwoHome.btnMore.setOnClickListener {
            myApp.ischeckd = "top_music"
            MoreClickListener()
        }

        binding.mouduleThreeHome.btnMore.setOnClickListener {
            myApp.ischeckd = "new_music"
            MoreClickListener()
        }

        binding.swipeHome.setOnRefreshListener {
            // load data hare

            Handler(Looper.getMainLooper()).postDelayed({
                binding.swipeHome.isRefreshing = false

            }, 800)
        }
    }

    private fun MoreClickListener() {


        when (myApp.ischeckd) {
            "happy_music" -> {
                Toast.makeText(context, "happy_music", Toast.LENGTH_SHORT).show()
            }

            "top_music" -> {
                Toast.makeText(context, "top_music", Toast.LENGTH_SHORT).show()
            }

            "new_music" -> {
                Toast.makeText(context, "new_music", Toast.LENGTH_SHORT).show()

            }


        }
    }

    override fun onDetach() {
        super.onDetach()
        presenter.OnDetavh()
    }


}