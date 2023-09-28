package com.example.daggerretro.ui

import com.example.daggerretro.di.MainApi
import com.example.daggerretro.model.JsonData
import io.reactivex.Flowable

class MainRepository (private val mainApi:MainApi):MainRepoInterface{
    override fun getAllData(): Flowable<List<JsonData>> {
        return mainApi.getAllData()
    }
}