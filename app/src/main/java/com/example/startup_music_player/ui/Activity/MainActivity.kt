package com.example.startup_music_player.ui.Activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.Toast
import androidx.core.content.ContextCompat
import androidx.core.graphics.toColor
import androidx.fragment.app.Fragment
import com.denzcoskun.imageslider.models.SlideModel
import com.example.startup_music_player.R
import com.example.startup_music_player.databinding.ActivityMainBinding
import com.example.startup_music_player.ui.Fragment.CategoryFragment
import com.example.startup_music_player.ui.Fragment.HomeFragment
import com.example.startup_music_player.ui.Fragment.ProfileFragment

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityMainBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        SelectedbtnNavigeyshen() // BtnNavigation
        Run() // run
        setSupportActionBar(binding.toolbarmain)
    }


    private fun SelectedbtnNavigeyshen() {
        binding.butennavigetion.setOnItemSelectedListener {
            when(it){
                R.id.Profile -> {
                    transform(ProfileFragment())
                }
                R.id.home -> {
                    transform(HomeFragment())
                }
                R.id.category -> {
                    transform(CategoryFragment())
                }
            }

        }
    }
    private fun transform(fragment : Fragment){
        val transform = supportFragmentManager.beginTransaction()
        transform.replace(R.id.FrameLayout,fragment)
        transform.commit()
    }
    private fun Run(){
        transform(HomeFragment()) // Added run time Fragment
        binding.butennavigetion.setItemSelected( R.id.home) // Select the executed item
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.meno_search_main,menu)
        return true

    }
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId){
            R.id.search ->{
                Toast.makeText(this, "test", Toast.LENGTH_SHORT).show()
            }
        }
        return true
    }


}