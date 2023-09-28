package com.example.daggerretro.ui

import androidx.lifecycle.LiveData
import com.example.daggerretro.model.JsonData

interface MainViewModelInterface {

    fun getDataList() : LiveData<Resource<List<JsonData>>>
    fun loadDataList()

}