package com.zatto.movieapp.views

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import com.zatto.movieapp.databinding.ActivityMoviesListBinding
import org.koin.androidx.viewmodel.ext.android.viewModel

class MovieOfferActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMoviesListBinding
    private val moviesViewModel: MovieOfferViewModel by viewModel()
    private val adapter: MovieOfferAdapter = MovieOfferAdapter()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMoviesListBinding.inflate(layoutInflater)
        binding.viewModel = moviesViewModel
        binding.adapter = adapter
        setUpViewModelObserver()
        setContentView(binding.root)
    }


    private fun setUpViewModelObserver() {

        moviesViewModel.movies().observe(this, Observer {
            adapter.update(it)
        })


        moviesViewModel.errorMessage.observe(
            this,
            Observer {
                Toast.makeText(this@MovieOfferActivity, it, Toast.LENGTH_SHORT).show()
            }
        )
    }
}