package com.example.startup_music_player.ui.features.Play

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.WindowManager
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.example.startup_music_player.R
import com.example.startup_music_player.databinding.FragmentMinimizePlayBinding
import com.example.startup_music_player.util.MyApp
import com.google.android.material.bottomsheet.BottomSheetDialog
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import com.squareup.picasso.Picasso


class minimizePlayFragment : Fragment() {
    lateinit var binding:FragmentMinimizePlayBinding
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = FragmentMinimizePlayBinding.inflate(layoutInflater,container,false)
        InitialData()
        setOnClick()
        if (MyApp.ispluing){
            binding.btnPlay.setImageResource(R.drawable.ic_pause)
        }
        binding.btnPlay.setOnClickListener { plymusic() }

        return binding.root
    }

    private fun setOnClick(){

    }
    private fun transform (fragment: Fragment) {
        val transform = parentFragmentManager.beginTransaction()
        transform.addToBackStack(null)
        transform.replace(R.id.FrameLayoutMain, fragment)
        transform.commit()
    }

    private fun plymusic() {
        if (MyApp.ispluing) {
            MyApp.media?.pause()
            binding.btnPlay.setImageResource(R.drawable.ic_play)
            MyApp.ispluing = false
        } else {
            MyApp.media?.start()
            binding.btnPlay.setImageResource(R.drawable.ic_pause)
            MyApp.ispluing = true
        }
    }
    private fun InitialData(){
            binding.txtArtist.text = MyApp.Artist_name
            binding.txtMusicName.text = MyApp.musicName
            Picasso.get().load(MyApp.img_cover).into(binding.imgCover)
        }



}