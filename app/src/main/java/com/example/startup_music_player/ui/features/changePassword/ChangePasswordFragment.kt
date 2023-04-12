package com.example.startup_music_player.ui.features.changePassword

import android.annotation.SuppressLint
import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.content.ContextCompat
import androidx.fragment.app.DialogFragment
import androidx.fragment.app.Fragment
import com.example.startup_music_player.R
import com.example.startup_music_player.databinding.DialogChangePasswordBinding
import com.example.startup_music_player.ui.Fragment.ProfileFragment
import com.example.startup_music_player.ui.features.Main.MainFragment
import com.example.startup_music_player.ui.features.Profile.ProfileViewModel
import com.example.startup_music_player.ui.features.Register.RegisterFragment
import com.google.android.material.snackbar.Snackbar
import ir.dunijet.dunibazaar.util.Not_SUCCESS
import ir.dunijet.dunibazaar.util.VALUE_SUCCESS
import org.koin.androidx.viewmodel.ext.android.viewModel
import java.util.*
import kotlin.concurrent.schedule

@SuppressLint("StaticFieldLeak")
lateinit var binding : DialogChangePasswordBinding
lateinit var sharedPref: SharedPreferences
class ChangePasswordFragment : Fragment() {
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View
    {
        binding = DialogChangePasswordBinding.inflate(layoutInflater , container , false)
        val timer = Timer()
        val handler = Handler()
        sharedPref = activity!!.getSharedPreferences("data" , Context.MODE_PRIVATE)
        binding.updatePassword.setOnClickListener {
            binding.animLock.playAnimation()
            val nowPass = sharedPref.getString("password" , "")

            if (binding.newePass.text.toString() == binding.repetitionpass.text.toString() && binding.OldPass.text.isNotEmpty() && binding.newePass.text.isNotEmpty()){
                update()

            }else {
                val r = Runnable {
                    binding.animLock.progress = 0F
                    binding.animLock.pauseAnimation()
                }
                Handler(Looper.getMainLooper()).postDelayed(r, 2500)

                if (binding.newePass.text.toString() != binding.repetitionpass.text.toString()){
                        SnackbarError("رمز عبور های جدید با هم همخوانی ندارند!")
                } else {
                    if (binding.OldPass.text.isEmpty() && binding.newePass.text.isEmpty()){
                        SnackbarError("لطفا مقادیر خواسته شده را پر کنید")

                    }else{
                        if (binding.OldPass.text.toString() != nowPass){
                            SnackbarError("رمز عبور اشتباه است")

                        }
                    }
                }
            }
        }
        return binding.root
    }
    fun update(){
        val viewmodel : ProfileViewModel by viewModel()
        viewmodel.old_password.value = binding.OldPass.text.toString()
        viewmodel.new_password.value = binding.newePass.text.toString()

        viewmodel.updatePassword {


            if (it == VALUE_SUCCESS){
                sharedPref.edit().putString("password" , binding.newePass.text.toString()).apply()

                //dismiss this fragmentDialog
                Log.v("changed" , "isChanged")
                // show dialog
                val dialog = PasswordIsChangedDialog()
                dialog.isCancelable = true
                dialog.show(childFragmentManager , null)
            }else{
            }
        }
    }

    private fun SnackbarError(text: String) {
        Snackbar
            .make(binding.root, text, Snackbar.LENGTH_LONG)
            .setBackgroundTint(ContextCompat.getColor(binding.root.context, R.color.light_blue))
            .setTextColor(ContextCompat.getColor(binding.root.context, R.color.white))
            .show()
    } // SnakBar

    override fun onDestroy() {
        super.onDestroy()
        val transform = parentFragmentManager.beginTransaction()
        transform.addToBackStack(null)
        transform.replace(R.id.FrameLayout, ProfileFragment())
        transform.commit()
    }

}