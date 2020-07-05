package com.zatto.movieapp.di

import com.zatto.movieapp.BuildConfig
import com.zatto.movieapp.data.repo.MovieRepo
import com.zatto.movieapp.data.repo.MovieRepoImpl
import com.zatto.movieapp.data.repo.MovieRepository
import com.zatto.movieapp.utilis.Connectivity
import com.zatto.movieapp.utilis.ConnectivityImpl
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.bind
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


val networkModule = module {
    single { provideRetrofit(get ()) }
    single { provideMovieService(get()) }
    factory { okHttpClient() }
    single { ConnectivityImpl(androidContext()) }.bind(Connectivity::class)
    single { MovieRepoImpl(get(),get()) }.bind(MovieRepository::class)

}

fun provideRetrofit(okHttpClient: OkHttpClient): Retrofit {
    return Retrofit.Builder().baseUrl(BuildConfig.BASE_URL).client(okHttpClient)
        .addConverterFactory(GsonConverterFactory.create())
        .build()
}


fun okHttpClient(): OkHttpClient {
    val interceptor: HttpLoggingInterceptor? = HttpLoggingInterceptor()
    interceptor!!.level = HttpLoggingInterceptor.Level.BODY
    return OkHttpClient().newBuilder().addInterceptor(interceptor).build()
}


fun provideMovieService(retrofit: Retrofit): MovieRepo =
    retrofit.create(MovieRepo::class.java)