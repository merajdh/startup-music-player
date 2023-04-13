package com.example.startup_music_player.ui

import android.content.*
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.example.startup_music_player.R
import com.example.startup_music_player.databinding.ActivityMainBinding
import com.example.startup_music_player.model.db.*
import com.example.startup_music_player.model.repository.TokenInMemory
import com.example.startup_music_player.model.repository.UserReposiroty
import com.example.startup_music_player.ui.features.Main.MainFragment
import com.example.startup_music_player.ui.features.Register.RegisterFragment
import com.example.startup_music_player.ui.features.intro.IntroFragment
import com.example.startup_music_player.util.MyApp
import com.example.startup_music_player.util.NetworkChecker
import org.koin.android.ext.android.get
import java.util.*
import kotlin.concurrent.schedule

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    lateinit var broadcastReceiver: BroadcastReceiver
    lateinit var MusicByCategoryDao: MusicByCategoryDao
    lateinit var MoreLikeDao: MoreLikeDao
    lateinit var RecentMusikDao: RecentMusikDao
    lateinit var TrendMusikDao: TrendMusikDao
    lateinit var internationalMusicDao: internationalMusicDao
    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityMainBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        chekinternet() //chekinternet
        val userReposiroty: UserReposiroty = get()
        userReposiroty.loadToken()
        transform(IntroFragment())
        if (TokenInMemory.access != "") {
            Timer().schedule(3000) {
                transform(MainFragment())
                MusicByCategoryDao = AppDatabase.getDatabes(binding.root.context).MusicByCategoryDao
                MoreLikeDao = AppDatabase.getDatabes(binding.root.context).MoreLikeDao
                RecentMusikDao = AppDatabase.getDatabes(binding.root.context).RecentMusikDao
                TrendMusikDao = AppDatabase.getDatabes(binding.root.context).TrendMusikDao
                internationalMusicDao = AppDatabase.getDatabes(binding.root.context).internationalMusicDao
            }
        } else {
            transform(RegisterFragment())
        }
    }

    private fun transform(fragment: Fragment) {
        val transform = supportFragmentManager.beginTransaction()
        transform.replace(R.id.FrameLayoutMain, fragment)
        transform.commit()
    } // transform btn navigeshen

    private fun chekinternet() {
        val internet: Boolean = NetworkChecker(this).isInternetConnected
        // broadcastReceiver ->
        broadcastReceiver = object : BroadcastReceiver() {
            override fun onReceive(p0: Context?, p1: Intent?) {
                if (!internet) {
                    //snalbar

                } else {

                }
            }
        }
        val intentfilter = IntentFilter("android.net.conn.CONNECTIVITY_CHANGE")
        registerReceiver(broadcastReceiver, intentfilter)

    }

    // Run every time
    override fun onDestroy() {
        super.onDestroy()
        MusicByCategoryDao.deletAllMusicByCategory()
        MoreLikeDao.deletAllMusicTop()
        RecentMusikDao.deletAllMusicNews()
        TrendMusikDao.deletAllMusicTrend()
        internationalMusicDao.deletAllMusicInternatioal()
    }
}