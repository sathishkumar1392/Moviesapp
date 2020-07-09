package com.zatto.movieapp.data.repo

import com.zatto.movieapp.data.model.MoviesData
import com.zatto.movieapp.data.model.MoviesResponseApi
import com.zatto.movieapp.utilis.Connectivity

class MovieRepoImpl constructor(
    private val connectivity: Connectivity,
    private val repo: MovieRepo
) : MovieRepository{


    override suspend fun getMoviesOffers() = getMovies()
    override suspend fun getMoviesData() = getMovieItemData()


    private suspend fun getMovies() : Result<MoviesResponseApi>{
        if (connectivity.isNetworkAvailable()){
            val response = repo.getMovieOffers()
            if (response.isSuccessful) {
                response.body()?.let {
                    return Result.Success(it)
                }
            }
            return Result.Error(response.errorBody().toString())
        }
        return Result.Error("No Internet Connection")
    }


    private suspend fun getMovieItemData(): Result<MoviesData> {
      if (connectivity.isNetworkAvailable()){
          val response  = repo.getMovieData()
          if (response.isSuccessful) {
              response.body()?.let {
                  return Result.Success(it)
              }
          }
          return Result.Error(response.errorBody().toString())
      }
      return Result.Error("No Internet Connection")
    }
}


