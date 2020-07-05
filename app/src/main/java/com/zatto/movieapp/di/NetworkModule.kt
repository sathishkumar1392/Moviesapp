package com.zatto.movieapp.di

import com.zatto.movieapp.views.MovieOfferAdapter
import com.zatto.movieapp.views.MovieOfferViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val movieModule = module {
    viewModel { MovieOfferViewModel(get()) }
    factory { MovieOfferAdapter() }
}