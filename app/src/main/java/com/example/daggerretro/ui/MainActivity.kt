package com.example.daggerretro.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import com.example.daggerretro.BaseActavity
import com.example.daggerretro.adapter.MovieAdapter
import com.example.daggerretro.databinding.ActivityMainBinding
import com.example.daggerretro.factory.ViewModelFactory
import com.example.daggerretro.model.movie.Result
import javax.inject.Inject

class MainActivity : AppCompatActivity() {

    @Inject
    lateinit var viewModelFactory: ViewModelFactory

    @Inject
    lateinit var movieAdapter: MovieAdapter
    lateinit var binding: ActivityMainBinding
    private lateinit var mainViewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        (this.applicationContext as BaseActavity).appComponent.newMainActivitySubComponent().inject(this)
        mainViewModel = ViewModelProvider(this, viewModelFactory)[MainViewModel::class.java]
        observeMovie()
    }
    private fun observeMovieList(){
           mainViewModel.loadPopularMovie()
        mainViewModel.getPopularMovieList().observe(this,{


            initRecyclerView(it)

        })

    }
    private fun observeMovie(){
        mainViewModel.loadPopularMovie()
        mainViewModel.getMovieData().observe(this,{
            when(it.status){
                Resource.Status.LOADING -> {
                    binding.progressBar.visibility = View.VISIBLE
                }
                Resource.Status.SUCCESS -> {
                    binding.progressBar.visibility = View.INVISIBLE
                    initRecyclerView(it.data)
                }
                Resource.Status.ERROR -> {
                    binding.progressBar.visibility = View.INVISIBLE
                    Toast.makeText(this, it.message, Toast.LENGTH_LONG).show()
                }
            }
        })
    }
    private fun initRecyclerView(movieList:List<Result>?){
        binding.recyclerview.setHasFixedSize(true)
        movieList?.let {
            movieAdapter.setMovieList(it)
        }
        binding.recyclerview.adapter=movieAdapter
    }

}