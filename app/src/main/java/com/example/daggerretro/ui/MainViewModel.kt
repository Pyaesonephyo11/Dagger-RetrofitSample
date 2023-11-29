package com.example.daggerretro.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MediatorLiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.daggerretro.model.movie.Movies
import com.example.daggerretro.model.movie.Result
import io.reactivex.disposables.CompositeDisposable
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import javax.inject.Inject

class MainViewModel @Inject constructor(private val mainRepository: MainRepository) : ViewModel() {

    private val movieMutableLiveData=MutableLiveData<List<Result>>()
    private val compositeDisposable=CompositeDisposable()
    private val mMutableLiveData = MediatorLiveData<Resource<List<Result>>>()


    init {
        loadPopularMovie()

    }


    fun getPopularMovieList():LiveData<List<Result>>{
        return movieMutableLiveData
    }

    fun getMovieData():LiveData<Resource<List<Result>>>{
        return mMutableLiveData
    }

    fun loadPopularMovie(){
         mainRepository.getPopularMovies().enqueue(object:Callback<Movies>{
             override fun onResponse(call: Call<Movies>, response: Response<Movies>) {
                 if (response.body()!=null){
                     movieMutableLiveData.value= response.body()!!.results

                     mMutableLiveData.value=Resource.success(response.body()!!.results)
                 }else{
                     mMutableLiveData.value=Resource.loading()
                 }
             }
             override fun onFailure(call: Call<Movies>, t: Throwable) {
                mMutableLiveData.value=Resource.error(t.message.toString(),null)
             }


         })
    }


    override fun onCleared() {
        super.onCleared()
        compositeDisposable.clear()
    }
}