package com.example.daggerretro.di

import androidx.lifecycle.ViewModel
import com.example.daggerretro.factory.ViewModelKey
import com.example.daggerretro.ui.MainViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
abstract class MainViewModelModule {

    @Binds
    @IntoMap
    @ViewModelKey(MainViewModel::class)
    internal abstract fun bindMainViewModel(viewModel: MainViewModel):ViewModel
}