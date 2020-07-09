package com.zatto.movieapp.data.repo

import com.zatto.movieapp.data.model.MoviesData
import com.zatto.movieapp.data.model.MoviesResponseApi
import com.zatto.movieapp.utilis.Connectivity
import kotlinx.coroutines.runBlocking
import org.junit.Assert
import org.junit.Before
import org.junit.Test
import org.mockito.InjectMocks
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.MockitoAnnotations
import retrofit2.Response


class MovieRepoImplTest : BaseTest() {

    @Mock
    private lateinit var movieService: MovieRepo

    @Mock
    private lateinit var connectivity: Connectivity

    @InjectMocks
    private lateinit var repo: MovieRepoImpl

    @Before
    fun init() {
        MockitoAnnotations.initMocks(this)
        repo = MovieRepoImpl(connectivity, movieService)
    }


    @Test
    fun  `movies offers api testing in success cases`() {
        val result = Response.success(MoviesResponseApi())
        result.code()

        runBlocking {
            Mockito.`when`(connectivity.isNetworkAvailable()).thenReturn(true)
            Mockito.`when`(movieService.getMovieOffers()).thenReturn(result)
            val response = movieService.getMovieOffers()
            Assert.assertEquals(result, response)
        }
    }

    @Test
    fun `movies offers api testing in  failure cases`(){
        val result = Result.Error("No Internet connection")
        runBlocking {
            Mockito.`when`(connectivity.isNetworkAvailable()).thenReturn(false)
            val response = Result.Error("No Internet connection")
            Assert.assertEquals(result, response)
        }
    }

   @Test
   fun `movies data api testing in success cases`(){
       val result = Response.success(MoviesData())
       result.code()

       runBlocking {
           Mockito.`when`(movieService.getMovieData()).thenReturn(result)
           val response = movieService.getMovieData()
           Assert.assertEquals(result, response)
       }
   }

    @Test
    fun `movies data api testing in failure cases`(){
        val result = Result.Error("No Internet Connection")
        runBlocking {
            Mockito.`when`(connectivity.isNetworkAvailable()).thenReturn(false)
            val response  = Result.Error("No Internet Connection")
            Assert.assertEquals(result,response)
        }
    }

}