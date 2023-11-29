package com.example.daggerretro.ui

import com.example.daggerretro.model.movie.Movies
import retrofit2.Call

interface MainRepoInterface {
    fun getPopularMovies(): Call<Movies>
}