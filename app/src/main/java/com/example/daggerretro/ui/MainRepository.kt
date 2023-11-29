package com.example.daggerretro.ui

import com.example.daggerretro.di.MainApi
import com.example.daggerretro.model.movie.Movies
import retrofit2.Call

class MainRepository (private val mainApi:MainApi):MainRepoInterface{
    override fun getPopularMovies(): Call<Movies> {
      return mainApi.getPopularMovies("11d4fbee2af9f6b42f5fcec50cc2e357")
    }


}