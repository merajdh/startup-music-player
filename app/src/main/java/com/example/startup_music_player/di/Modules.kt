package com.example.startup_music_player.di

import android.content.Context
import com.example.startup_music_player.model.net.createApiService
import com.example.startup_music_player.model.repository.UserReposiroty
import com.example.startup_music_player.model.repository.UserReposirotyImpl
import com.example.startup_music_player.ui.features.LoginViewModel
import com.example.startup_music_player.ui.features.RegisterViewModel
import org.koin.android.ext.koin.androidApplication
import org.koin.android.ext.koin.androidContext
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val myModules = module {

    single { androidContext().getSharedPreferences("data",Context.MODE_PRIVATE) }
    single { createApiService() }
    single<UserReposiroty> { UserReposirotyImpl(get(),get () ) }
    viewModel{LoginViewModel(get())}
    viewModel{RegisterViewModel(get())}
}