package com.example.startup_music_player.util

import android.app.Application
import android.content.Context
import com.example.startup_music_player.model.net.createApiService
import com.example.startup_music_player.model.repository.UserReposiroty
import com.example.startup_music_player.model.repository.UserReposirotyImpl
import com.example.startup_music_player.ui.features.Login.LoginViewModel
import com.example.startup_music_player.ui.features.Register.RegisterViewModel
import com.example.startup_music_player.ui.features.verify.VerifyViewModel
import org.koin.android.ext.koin.androidContext
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.core.context.startKoin
import org.koin.dsl.module

class MyApp : Application() {
    companion object {
        var idMusic : String = ""
        var access : String = "TokenInMemory.access.toString()"
    }

    override fun onCreate() {
        super.onCreate()
        val myModuled = module {

            single { androidContext().getSharedPreferences("data", Context.MODE_PRIVATE) }
            single { createApiService() }
            single<UserReposiroty> { UserReposirotyImpl(get(), get()) }
            viewModel { LoginViewModel(get()) }
            viewModel { RegisterViewModel(get()) }
            viewModel { VerifyViewModel(get()) }
        }
        startKoin {
            androidContext(this@MyApp)
            modules(myModuled)
        }
    }
}