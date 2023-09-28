package com.example.daggerretro.ui

import com.example.daggerretro.model.JsonData
import io.reactivex.Flowable

interface MainRepoInterface {

    fun getAllData():Flowable<List<JsonData>>
}