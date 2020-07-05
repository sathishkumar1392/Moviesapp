package com.zatto.movieapp.views

import com.zatto.movieapp.data.repo.BaseTest
import com.zatto.movieapp.data.model.MoviesResponseApi
import com.zatto.movieapp.data.repo.MovieRepository
import com.zatto.movieapp.data.repo.Result
import kotlinx.coroutines.runBlocking
import org.junit.Before
import org.junit.Test
import org.junit.Assert.*
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.MockitoAnnotations


class MovieOfferViewModelTest : BaseTest(){

    private lateinit var viewModel : MovieOfferViewModel

    @Mock
    private lateinit var useCase: MovieRepository

    private val moviesList = MoviesResponseApi()


    @Before
    fun `viewmodel is initialized with movies `() {
            MockitoAnnotations.initMocks(this)
            viewModel = MovieOfferViewModel(useCase)
    }

    @Test
    fun `return movies offers list `()  = runBlocking {
        val result = Result.Success(moviesList)
        Mockito.`when`(useCase.getMoviesOffers()).thenReturn(result)
        val response = useCase.getMoviesOffers()
        assertEquals(result, response)
    }

    @Test
    fun `cannot return movie offers list in absence of network`() = runBlocking {
        val result = Result.Error("No Internet Connection")
        Mockito.`when`(useCase.getMoviesData()).thenReturn(result)
        val response = Result.Error("No Internet Connection")
        assertEquals(result, response)
    }
}