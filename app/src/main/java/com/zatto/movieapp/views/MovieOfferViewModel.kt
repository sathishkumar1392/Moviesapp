package com.zatto.movieapp.views

import androidx.lifecycle.MutableLiveData
import com.zatto.movieapp.data.endpointpath.Constant
import com.zatto.movieapp.data.model.MovieData
import com.zatto.movieapp.data.model.MovieOffer
import com.zatto.movieapp.data.model.MoviesResponseApi
import com.zatto.movieapp.data.model.addMovieOffer
import com.zatto.movieapp.data.repo.MovieRepository
import com.zatto.movieapp.data.repo.Result
import com.zatto.movieapp.utilis.BaseViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.Dispatchers.Main
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class MovieOfferViewModel(private val repo: MovieRepository) : BaseViewModel() {

    private var moviesOffersLiveData: MutableLiveData<List<MovieData>> = MutableLiveData()

    private var moviesOffers: List<MovieOffer> = mutableListOf()
    private var moviesItemData: List<MovieData>? = null
    fun movies() = moviesOffersLiveData


    init {
        CoroutineScope(IO).launch {
            movieApiRequest()
        }
    }


    private suspend fun movieApiRequest() {


         CoroutineScope(IO).launch {
            val movieDataJob1 = launch {
                when (val result = repo.getMoviesData()) {

                    is Result.Success -> {
                        val response = result.data.movieData
                        moviesItemData = response
                    }
                    is Result.Error -> {
                        errorMessage.postValue(result.data)
                    }
                }


            }
            movieDataJob1.join()


            val movieOfferJob2 = launch {
                when (val result = repo.getMoviesOffers()) {
                    is Result.Success -> {
                        val response = result.data
                        setDataOnMainThread(response)
                    }
                    is Result.Error -> {
                        errorMessage.postValue(result.data)
                    }
                }
                isLoading.set(false)
            }
            movieOfferJob2.join()

        }

    }

    private suspend fun setDataOnMainThread(response: MoviesResponseApi) {
        withContext(Main) {
            Constant.TAG_IMAGEURL = response.imageBase
            moviesOffers = response.movieOffers
            addMovieOfferToMovie(moviesItemData!!, moviesOffers)
            moviesOffersLiveData.value = moviesItemData
        }

    }
}

    private fun addMovieOfferToMovie(moviesList: List<MovieData>, offersList: List<MovieOffer>) {
    val offersSequence = offersList.asSequence()

    moviesList.forEach {
        it.addMovieOffer(offersSequence)
    }
}



