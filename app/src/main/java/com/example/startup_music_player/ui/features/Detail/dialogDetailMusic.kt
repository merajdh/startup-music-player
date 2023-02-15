package com.example.startup_music_player.ui.features.Detail

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import com.example.startup_music_player.R
import com.example.startup_music_player.databinding.FragmentDetailBinding
import com.example.startup_music_player.ui.features.Artist.ArtistFragment
import com.example.startup_music_player.ui.features.Report.ReportFragment
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import com.google.android.material.snackbar.Snackbar

@SuppressLint("StaticFieldLeak")
lateinit var binding: FragmentDetailBinding
class DetaiMusiclFragment : BottomSheetDialogFragment() {
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = FragmentDetailBinding.inflate(layoutInflater, container, false)
        setOnClickListeners()
        return binding.root
    }
    private fun setOnClickListeners(){
        //moudule Two ->
        binding.mouduleTwoDetail.btnAddToPlaylist.setOnClickListener {
        }

        binding.mouduleTwoDetail.btnAddToFavorite.setOnClickListener {
            Snackbar("موزیک مورد نظر به مورد علاقه های شما اضافه شد")
        }

        binding.mouduleTwoDetail.btnArtist.setOnClickListener {
            dialog?.dismiss()
            transform(ArtistFragment())
        }

        binding.mouduleTwoDetail.btnShare.setOnClickListener {
        }

        binding.mouduleTwoDetail.btnReport.setOnClickListener {
            dialog?.dismiss()
            val transform = (ReportFragment())
            transform.show(parentFragmentManager , null)
        }
    }
    override fun getTheme() = R.style.RoundedCornersBottomSheetDialog

        private fun transform (fragment: Fragment) {
            val transform = parentFragmentManager.beginTransaction()
            transform.replace(R.id.FrameLayoutMain, fragment)
            transform.addToBackStack(null)
            transform.commit()
        }

    private fun Snackbar(text: String) {
        Snackbar
            .make(binding.root, text, Snackbar.LENGTH_LONG)
            .setBackgroundTint(ContextCompat.getColor(binding.root.context, R.color.light_blue))
            .setTextColor(ContextCompat.getColor(binding.root.context, R.color.white))
            .show()
    }
}