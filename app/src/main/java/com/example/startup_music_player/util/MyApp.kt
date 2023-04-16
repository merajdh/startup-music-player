package com.example.startup_music_player.util

import android.app.Application
import android.content.Context
import android.media.MediaPlayer
import androidx.room.Room
import com.example.startup_music_player.model.db.AppDatabase
import com.example.startup_music_player.model.net.createApiService
import com.example.startup_music_player.model.repository.Like.LikeRepository
import com.example.startup_music_player.model.repository.Like.LikeRepositorylmpl
import com.example.startup_music_player.model.repository.ticket.ticketrepository
import com.example.startup_music_player.model.repository.ticket.ticketrepositoryimpl
import com.example.startup_music_player.model.repository.user.UserReposiroty
import com.example.startup_music_player.model.repository.user.UserReposirotyImpl
import com.example.startup_music_player.ui.features.Login.LoginViewModel
import com.example.startup_music_player.ui.features.Play.LikeViewModel
import com.example.startup_music_player.ui.features.Profile.ProfileViewModel
import com.example.startup_music_player.ui.features.Register.RegisterViewModel
import com.example.startup_music_player.ui.features.verify.VerifyViewModel
import org.koin.android.ext.koin.androidContext
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.core.context.startKoin
import org.koin.dsl.module

class MyApp : Application() {
    companion object {
        var img_cover : String = ""
        var musicName : String = ""
        var Artist_name : String = ""
        var isInUse : Boolean= false
        var idMusic: String = ""
        var idTicket: String = ""
        var musicserch: String = ""
        var ispluing: Boolean = false
        var idArtist: String = ""
        var idCategory: String = ""
        var ischeckd: String = ""
        var media : MediaPlayer? = null
        var isSend : Boolean = false
    }

    override fun onCreate() {
        super.onCreate()
        val myModuled = module {
            single { androidContext().getSharedPreferences("data", Context.MODE_PRIVATE) }
            single { createApiService() }
            single { Room.databaseBuilder(androidContext(), AppDatabase::class.java, "app_dataBase") }
            single<UserReposiroty> { UserReposirotyImpl(get(), get()) }
            single<LikeRepository> { LikeRepositorylmpl(get())}
            single<ticketrepository> { ticketrepositoryimpl(get())}
            viewModel { LoginViewModel(get()) }
            viewModel { RegisterViewModel(get()) }
            viewModel { VerifyViewModel(get()) }
            viewModel { LikeViewModel(get()) }
            viewModel { ProfileViewModel(get()) }
        }
        startKoin {
            androidContext(this@MyApp)
            modules(myModuled)
        }
    }
}