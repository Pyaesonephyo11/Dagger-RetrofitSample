package com.example.daggerretro

import com.example.daggerretro.di.MainActivitySubComponent
import dagger.Component


@Component(modules = [NetworkModule::class])
interface AppComponent {
    fun newMainActivitySubComponent() : MainActivitySubComponent
}