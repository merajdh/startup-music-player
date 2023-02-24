package com.example.startup_music_player.ui.features.Myplaylist

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.startup_music_player.R
import com.example.startup_music_player.databinding.FragmentMyplaylistBinding
import com.example.startup_music_player.ui.Fragment.ProfileFragment
import com.example.startup_music_player.ui.features.DetailPlaylist.detailPlaylistFragment
import com.example.startup_music_player.ui.features.PlayList.PlayListFragment

@SuppressLint("StaticFieldLeak")
lateinit var binding: FragmentMyplaylistBinding


    class MyplaylistFragment : Fragment() {
        lateinit var binding: FragmentMyplaylistBinding
        override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
            binding = FragmentMyplaylistBinding.inflate(layoutInflater, container, false)
            setOnClickListener()
            return binding.root
        }

        private fun setOnClickListener() {
            binding.btnBack.setOnClickListener {
                parentFragmentManager.popBackStack()
            }

            binding.item1.btnMore.setOnClickListener {
                val transform = detailPlaylistFragment()
                transform.isCancelable = true
                transform.show(childFragmentManager , null)
            }
            binding.item2.btnMore.setOnClickListener {
                val transform = detailPlaylistFragment()
                transform.isCancelable = true
                transform.show(childFragmentManager , null)
            }
            binding.item3.btnMore.setOnClickListener {
                val transform = detailPlaylistFragment()
                transform.isCancelable = true
                transform.show(childFragmentManager , null)
            }


            binding.item1.itemPlaylist.setOnClickListener {
                transform(PlayListFragment())
            }

            binding.item2.itemPlaylist.setOnClickListener {
                transform(PlayListFragment())
            }

            binding.item3.itemPlaylist.setOnClickListener {
                transform(PlayListFragment())
            }
        }

        override fun onDestroy() {
            super.onDestroy()
            val transform = parentFragmentManager.beginTransaction()
            transform.addToBackStack(null)
            transform.replace(R.id.FrameLayout, ProfileFragment())
            transform.commit()
        }

        private fun transform(fragment: Fragment) {
            val transform = parentFragmentManager.beginTransaction()
            transform.replace(R.id.FrameLayoutMain, fragment)
            transform.commit()
        }

    }

