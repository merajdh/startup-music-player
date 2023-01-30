package com.example.startup_music_player.di

import com.example.startup_music_player.model.repository.UserReposiroty
import com.example.startup_music_player.model.repository.UserReposirotyImpl
import com.example.startup_music_player.ui.features.LoginViewModel
import com.example.startup_music_player.ui.features.RegisterViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val myModules = module {

    single {  }
    single<UserReposiroty> { UserReposirotyImpl() }

    viewModel{LoginViewModel(get())}
    viewModel{RegisterViewModel(get())}
}