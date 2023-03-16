package com.example.startup_music_player.ui.features.verify

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import cn.pedant.SweetAlert.SweetAlertDialog
import com.example.startup_music_player.R
import com.example.startup_music_player.databinding.FragmentRegisterBinding
import com.example.startup_music_player.databinding.FragmentVerifyEmailBinding
import com.example.startup_music_player.ui.features.Main.MainFragment
import com.example.startup_music_player.ui.features.Register.RegisterViewModel
import ir.dunijet.dunibazaar.util.VALUE_SUCCESS
import org.koin.androidx.viewmodel.ext.android.viewModel

class VerifyEmailFragment : Fragment() {
    lateinit var binding: FragmentVerifyEmailBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        binding = FragmentVerifyEmailBinding.inflate(layoutInflater,container,false)
        val viewmodel : VerifyViewModel by viewModel()

        binding.btnVerify.setOnClickListener{
            if (binding.EdtCode.text.isNotEmpty()){
                viewmodel.code.value = binding.EdtCode.text.toString()
                viewmodel.VerifyEmail {
                    if (it == VALUE_SUCCESS){

                        val dialog = SweetAlertDialog(context, SweetAlertDialog.SUCCESS_TYPE)
                        dialog.titleText = "خوش امدید"
                        dialog.contentText = "ایمیل شما با موفقیت تایید شد!"
                        dialog.show()
                        val transform = parentFragmentManager.beginTransaction()
                        transform.replace(R.id.FrameLayoutMain,MainFragment())
                        transform.commit()
                    }else{
                        val dialog = SweetAlertDialog(context, SweetAlertDialog.ERROR_TYPE)
                        dialog.titleText = "اوپس"
                        dialog.contentText = "کد شما اشتباه است!"
                        dialog.show()
                    }
            }

            }else{
                // SnakBar
            }
        }
        return binding.root
    }

}
