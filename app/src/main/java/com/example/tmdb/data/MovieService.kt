package com.example.tmdb.data

import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface MovieService {
    @GET("movie/now_playing")
    suspend fun getNowPlaying(
        @Query("api_key") apiKey: String
    ): Response<MovieResponse>

    @GET("movie/popular")
    suspend fun getPopular(
        @Query("api_key") apiKey: String
    ): Response<MovieResponse>

    @GET("movie/top_rated")
    suspend fun getTopRated(
        @Query("api_key") apiKey: String
    ): Response<MovieResponse>

    @GET("movie/upcoming")
    suspend fun getUpcoming(
        @Query("api_key") apiKey: String
    ): Response<MovieResponse>

}