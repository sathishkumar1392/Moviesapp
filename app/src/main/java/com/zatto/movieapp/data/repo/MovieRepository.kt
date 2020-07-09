package com.zatto.movieapp.data.repo

import com.zatto.movieapp.data.model.MoviesData
import com.zatto.movieapp.data.model.MoviesResponseApi
import retrofit2.Response


interface MovieRepository  {

   suspend fun getMoviesOffers() : Result<MoviesResponseApi>
   suspend fun getMoviesData() :Result<MoviesData>

}