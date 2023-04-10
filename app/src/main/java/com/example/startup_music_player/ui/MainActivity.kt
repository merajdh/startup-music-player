package com.example.startup_music_player.ui

import android.content.*
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.example.startup_music_player.R
import com.example.startup_music_player.databinding.ActivityMainBinding
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
            }
        }else{
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

                }else{

                }
            }
        }
        val intentfilter = IntentFilter("android.net.conn.CONNECTIVITY_CHANGE")
        registerReceiver(broadcastReceiver, intentfilter)

    }
// Run every time

}