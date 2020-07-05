package com.zatto.movieapp.data.repo

import com.zatto.movieapp.data.endpointpath.EndPointsPath
import com.zatto.movieapp.data.model.MoviesData
import com.zatto.movieapp.data.model.MoviesResponseApi
import retrofit2.Response
import retrofit2.http.GET

interface MovieRepo {

    @GET(EndPointsPath.Movies.MOVIESOFFERS)
    suspend fun getMovieOffers(): Response<MoviesResponseApi>


    @GET(EndPointsPath.Movies.MOVIESDATA)
    suspend fun getMovieData():Response<MoviesData>
}