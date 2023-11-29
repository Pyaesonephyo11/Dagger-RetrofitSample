package com.example.daggerretro.di

import com.example.daggerretro.model.movie.Movies
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface MainApi {

    @GET("popular?")
    fun getPopularMovies(@Query("api_key") api_key : String) : Call<Movies>


}