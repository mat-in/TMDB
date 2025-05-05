package com.example.tmdb.data

import com.google.gson.GsonBuilder
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
class RetrofitInstance {

    var BASEURL = "https://api.themoviedb.org/3/"
    fun getRetrofitInstance(): Retrofit{
        return Retrofit.Builder()
            .baseUrl(BASEURL)
            .addConverterFactory(GsonConverterFactory.create(GsonBuilder().create()))
            .build()
    }
}