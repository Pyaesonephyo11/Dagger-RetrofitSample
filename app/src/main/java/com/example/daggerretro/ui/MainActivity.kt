package com.example.daggerretro.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.daggerretro.BaseActavity
import com.example.daggerretro.R
import com.example.daggerretro.adapter.RecyclerAdapter
import com.example.daggerretro.databinding.ActivityMainBinding
import com.example.daggerretro.factory.ViewModelFactory
import com.example.daggerretro.model.JsonData
import javax.inject.Inject

class MainActivity : AppCompatActivity() {

    private lateinit var mainViewModel: MainViewModel

    @Inject
    lateinit var viewModelFactory: ViewModelFactory

    @Inject
    lateinit var recyclerViewAdapter: RecyclerAdapter

    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //setContentView(R.layout.activity_main)
        binding=ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        (this.applicationContext as BaseActavity).appComponent.newMainActivitySubComponent().inject(this)

        mainViewModel = ViewModelProvider(this, viewModelFactory)[MainViewModel::class.java]
        observeUserList()
    }

    private fun observeUserList() {
        mainViewModel.getDataList().observe(this, Observer {
            when(it.status){
                Resource.Status.LOADING -> {
                    binding.progressBar.visibility = View.VISIBLE
                }
                Resource.Status.SUCCESS -> {
                    binding.progressBar.visibility = View.INVISIBLE
                    intRecyclerView(it.data)
                }
                Resource.Status.ERROR -> {
                    binding.progressBar.visibility = View.INVISIBLE
                    Toast.makeText(this, it.message, Toast.LENGTH_LONG).show()
                }
            }
        })
    }



    private fun intRecyclerView(list: List<JsonData>?) {
        binding.recyclerview.setHasFixedSize(true)
        list?.let { recyclerViewAdapter.setData(it) }
        binding.recyclerview.adapter = recyclerViewAdapter

    }

}