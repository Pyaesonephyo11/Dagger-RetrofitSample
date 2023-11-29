package com.example.daggerretro

import android.app.Application



class BaseActavity :Application(){


    lateinit var appComponent: AppComponent

    override fun onCreate() {
        super.onCreate()
        this.appComponent=this.intDagger()
    }

    private fun intDagger() =DaggerAppComponent.builder()
        .networkModule(NetworkModule())
        .build()
}