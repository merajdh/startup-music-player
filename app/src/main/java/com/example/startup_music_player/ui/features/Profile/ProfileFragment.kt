package com.example.startup_music_player.ui.Fragment

import android.app.AlertDialog
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.startup_music_player.R
import com.example.startup_music_player.databinding.DiaogLogoutBinding
import com.example.startup_music_player.databinding.FragmentProfileBinding
import com.example.startup_music_player.ui.features.About.AboutFragment
import com.example.startup_music_player.ui.features.ChangeUsername.ChangeUsernameFragment
import com.example.startup_music_player.ui.features.ContactUs.ContactUsFragment
import com.example.startup_music_player.ui.features.LikedMusic.LikedMusicFragment
import com.example.startup_music_player.ui.features.Myplaylist.MyplaylistFragment
import com.example.startup_music_player.ui.features.Profile.ProfileViewModel
import com.example.startup_music_player.ui.features.Register.RegisterFragment
import com.example.startup_music_player.ui.features.changePassword.ChangePasswordFragment
import org.koin.androidx.viewmodel.ext.android.viewModel

class ProfileFragment : Fragment() {

    lateinit var binding: FragmentProfileBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        binding = FragmentProfileBinding.inflate(layoutInflater , container , false)
        setOnClickListeners()
        return binding.root
    }




    private fun transform (fragment: Fragment) {
        val transform = parentFragmentManager.beginTransaction()
        transform.addToBackStack(null)
        transform.replace(R.id.FrameLayoutMain, fragment)
        transform.commit()
    }


    private fun setOnClickListeners(){
        // mouduleOne ->


        binding.mouduleOne.btnChangeUsername.setOnClickListener {
            val transform = ChangeUsernameFragment()
            transform.isCancelable = true
            transform.show(parentFragmentManager , null)
        }
        // mouduleTwo ->
        binding.mouduleTwo.btnChangePassword.setOnClickListener {
            transform(ChangePasswordFragment())
        }
        binding.mouduleTwo.btnMyplaylist.setOnClickListener {
            transform(  MyplaylistFragment())
        }
        binding.mouduleTwo.btnLiked.setOnClickListener {
            transform(LikedMusicFragment())
        }

        // mouduleThree ->
        binding.mouduleThree.btnComment.setOnClickListener {
            transform(ContactUsFragment())
        }
        binding.mouduleThree.btnAbout.setOnClickListener {
            transform(AboutFragment())
        }
        binding.mouduleThree.btnLogout.setOnClickListener {
            val dialog = AlertDialog.Builder(context).create()
            val view = DiaogLogoutBinding.inflate(layoutInflater)
            view.btnAccept.setOnClickListener { Loguot()
            dialog.dismiss()}
            view.btnCancel.setOnClickListener { dialog.dismiss() }
            dialog.setView(view.root)
            dialog.setCancelable(true)
            dialog.show()

        }

    }
    private fun Loguot() {
        val viewmodel : ProfileViewModel by viewModel()
        viewmodel.singout()
        transform(RegisterFragment())

    }

}