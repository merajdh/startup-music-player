package com.example.startup_music_player.ui.features.verify

import android.os.Bundle
import android.os.CountDownTimer
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import cn.pedant.SweetAlert.SweetAlertDialog
import com.example.startup_music_player.R
import com.example.startup_music_player.databinding.FragmentVerifyEmailBinding
import com.example.startup_music_player.ui.features.Main.MainFragment
import ir.dunijet.dunibazaar.util.VALUE_SUCCESS
import org.koin.androidx.viewmodel.ext.android.viewModel

class VerifyEmailFragment : Fragment()
{
    lateinit var binding: FragmentVerifyEmailBinding
    var timeRemaining = 120
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        binding = FragmentVerifyEmailBinding.inflate(layoutInflater, container, false)
        val viewmodel: VerifyViewModel by viewModel()

        timer()

        for (i in timeRemaining.toString()) {
            binding.txtSendCode.setOnClickListener {
                binding.txtSendCode.setTextColor(ContextCompat.getColor(binding.root.context, R.color.light_blue))

                timer()
            }

        }



        binding.btnVerify.setOnClickListener {
            if (binding.EdtCode.text.isNotEmpty()) {
                viewmodel.code.value = binding.EdtCode.text.toString()
                viewmodel.VerifyEmail {
                    if (it == VALUE_SUCCESS) {

                        val dialogVerify = VerifyDialogFragment()
                        dialogVerify.show(parentFragmentManager, null)
                        val transform = parentFragmentManager.beginTransaction()
                        transform.replace(R.id.FrameLayoutMain, MainFragment())
                        transform.commit()
                    } else {
                        val dialogReject = VerifyRejectedDialogFragment()
                        dialogReject.show(parentFragmentManager, null)
                    }
                }

            } else {
                // SnakBar
            }
        }
        return binding.root
    }

    private fun timer(){
        val TWO_MINUTES: Long = 2 * 60 * 1000 // 2 minutes in milliseconds
        val timer = object : CountDownTimer(TWO_MINUTES, 1000) {
            override fun onTick(millisUntilFinished: Long) {
                val timeRemaining = millisUntilFinished / 1000
                binding.txtSendCode.isClickable = timeRemaining.toString() == "0"

                binding.txtTimer.text = "$timeRemaining"
            }

            override fun onFinish() {
                binding.txtSendCode.setTextColor(ContextCompat.getColor(binding.root.context, R.color.Gray))
            }
        }
        timer.start()
    }
}




