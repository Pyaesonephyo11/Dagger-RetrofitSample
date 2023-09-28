package com.example.daggerretro.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MediatorLiveData
import androidx.lifecycle.ViewModel
import com.example.daggerretro.model.JsonData
import io.reactivex.Scheduler
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

class MainViewModel @Inject constructor(private val mainRepository: MainRepository) : ViewModel() {

    private val tag:String=MainViewModel::class.java.name

    private val dataMutableLiveData=MediatorLiveData<Resource<List<JsonData>>>()
    private val compositeDisposable=CompositeDisposable()

    init {
        loadDataList()
    }

    fun getDataList(): LiveData<Resource<List<JsonData>>> {
       return dataMutableLiveData
    }

    fun loadDataList() {
       var disposable = mainRepository.getAllData()
           .subscribeOn(Schedulers.io())
           .observeOn(AndroidSchedulers.mainThread())
           .doOnSubscribe {
               dataMutableLiveData.value=Resource.loading()
           }
           .subscribe ({
               dataMutableLiveData.value=Resource.success(it)
           },{
               dataMutableLiveData.value=Resource.error(it.localizedMessage,null)
           })
        compositeDisposable.add(disposable)
    }


    override fun onCleared() {
        super.onCleared()
        compositeDisposable.clear()
    }
}