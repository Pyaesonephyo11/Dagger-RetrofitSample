package com.example.daggerretro.di

import com.example.daggerretro.model.JsonData
import io.reactivex.Flowable
import retrofit2.http.GET

interface MainApi {

    @GET("photos")
    fun getAllData():Flowable<List<JsonData>>
}