package com.example.daggerretro.di

import com.example.daggerretro.ViewModelFactoryModule
import com.example.daggerretro.factory.ViewModelFactory
import com.example.daggerretro.ui.MainActivity
import dagger.Subcomponent


@Subcomponent(modules = [
    MainModule::class,
ViewModelFactoryModule::class,
MainViewModelModule::class
])
interface MainActivitySubComponent {
    fun inject(mainActivity: MainActivity)
}