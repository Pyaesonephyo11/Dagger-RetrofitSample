package com.example.daggerretro.di

import androidx.recyclerview.widget.RecyclerView
import com.example.daggerretro.adapter.MovieAdapter
import com.example.daggerretro.ui.MainActivity
import com.example.daggerretro.ui.MainRepository
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit



@Module
class MainModule {


    @Provides
    fun provideMainApi(retrofit: Retrofit):MainApi{
        return retrofit.create(MainApi::class.java)
    }

    @Provides
    fun provideMainRepository(mainApi: MainApi):MainRepository{
        return MainRepository(mainApi)
    }

    @Provides
    fun provideMovieAdapter()=MovieAdapter()
}