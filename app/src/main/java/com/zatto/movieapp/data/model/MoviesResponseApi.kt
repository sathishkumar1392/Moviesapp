package com.zatto.movieapp.data.model

import com.google.gson.annotations.SerializedName


data class MoviesResponseApi(
    @SerializedName("image_base")
    val imageBase: String = "", // https://dummyimage.com
    @SerializedName("movie_offers")
    val movieOffers: List<MovieOffer> = listOf()
)

fun MovieData.addMovieOffer(offers: Sequence<MovieOffer>) {
    val moveOffer = offers.first { offer ->
        offer.movieId == this.movieId
    }

    this.offer = moveOffer
}

data class MovieOffer(
    @SerializedName("available")
    val available: Boolean = false, // false
    @SerializedName("image")
    val image: String = "", // /600x400/
    @SerializedName("movie_id")
    var movieId: Int = 0, // 1
    @SerializedName("price")
    val price: String = "" // 32.00€
)

data class MoviesData(
    @SerializedName("movie_data")
    val movieData: List<MovieData> = listOf()
)

data class MovieData(
    @SerializedName("movie_id")
    val movieId: Int = 0, // 1
    @SerializedName("sub_title")
    val subTitle: String = "", // Every Man
    @SerializedName("title")
    val title: String = "",// Entwined Voyages
    var offer: MovieOffer? = null
)