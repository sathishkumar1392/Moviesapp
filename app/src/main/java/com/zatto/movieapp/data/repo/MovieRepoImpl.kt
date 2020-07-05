package com.zatto.movieapp.data.repo

import com.zatto.movieapp.data.model.MoviesData
import com.zatto.movieapp.data.model.MoviesResponseApi
import com.zatto.movieapp.utilis.Connectivity

class MovieRepoImpl constructor(
    private val connectivity: Connectivity,
    private val repo: MovieRepo
) : MovieRepository{

    override suspend fun getMoviesOffers(): Result<MoviesResponseApi> {
        return if (connectivity.isNetworkAvailable()){
                  getMovies()
        }else return Result.Error("No Internet Connection")
    }


    override suspend fun getMoviesData(): Result<MoviesData> {
        return if (connectivity.isNetworkAvailable()){
            getMovieItemData()
        }else return Result.Error("No Internet Connection")
    }


    private suspend fun getMovies() : Result<MoviesResponseApi>{
        val response = repo.getMovieOffers()
        if (response.isSuccessful) {
            response.body()?.let {
                return Result.Success(it)
            }
        }
        return Result.Error(response.errorBody().toString())
    }


  private suspend fun getMovieItemData(): Result<MoviesData> {
      val response  = repo.getMovieData()
      if (response.isSuccessful) {
          response.body()?.let {
              return Result.Success(it)
          }
      }
      return Result.Error(response.errorBody().toString())
    }

}


