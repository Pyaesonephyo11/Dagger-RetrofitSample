package com.example.daggerretro

import androidx.lifecycle.ViewModelProvider
import com.example.daggerretro.factory.ViewModelFactory
import dagger.Binds
import dagger.Module


@Module
abstract class ViewModelFactoryModule {

    @Binds
    internal abstract fun bindViewModelFactory(factory:ViewModelFactory):ViewModelProvider.Factory
}