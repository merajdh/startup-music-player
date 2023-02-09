package com.example.startup_music_player.ui.Fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.startup_music_player.R
import com.example.startup_music_player.databinding.FragmentProfileBinding
import com.example.startup_music_player.ui.features.BottomsheetDetail.DetaiMusiclFragment
import com.example.startup_music_player.ui.features.LikedMusic.LikedMusicFragment
import com.example.startup_music_player.ui.features.Myplaylist.MyplaylistFragment
import com.example.startup_music_player.ui.features.Myplaylist.binding
import com.example.startup_music_player.ui.features.changePassword.fragmentDialog

class ProfileFragment : Fragment() {

    lateinit var binding: FragmentProfileBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentProfileBinding.inflate(layoutInflater , container , false)
        setOnClickListeners()
        return binding.root
    }

    private fun transform (fragment: Fragment) {
        val transform = parentFragmentManager.beginTransaction()
        transform.replace(R.id.FrameLayoutMain, fragment)
        transform.commit()
    }

    private fun setOnClickListeners(){
        // mouduleOne ->
        binding.mouduleOne.btnChangeUsername.setOnClickListener {

            val transform = (DetaiMusiclFragment())
            transform.show(parentFragmentManager , null)
        }
        // mouduleTwo ->
        binding.mouduleTwo.btnChangePassword.setOnClickListener {
            val transform = fragmentDialog()
            transform.isCancelable = true
            transform.show(parentFragmentManager , null)
        }
        binding.mouduleTwo.btnMyplaylist.setOnClickListener {
            transform(MyplaylistFragment())
        }
        binding.mouduleTwo.btnLiked.setOnClickListener {
            transform(LikedMusicFragment())

        }
        // mouduleThree ->
        binding.mouduleThree.btnComment.setOnClickListener {

        }
        binding.mouduleThree.btnAbout.setOnClickListener {

        }
        binding.mouduleThree.btnLogout.setOnClickListener {

        }


    }
}