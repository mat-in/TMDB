package com.example.tmdb.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.tmdb.data.Movie
import com.example.tmdb.data.MovieService
import com.example.tmdb.data.RetrofitInstance
import kotlinx.coroutines.launch

class MovieViewModel: ViewModel() {
    var movieLiveData = MutableLiveData<List<Movie>>()
    var errorLiveData = MutableLiveData<String>()
    var apiKey = "d0e6835cd25a693076c898466f4382c8"

    var retrofitinstance = RetrofitInstance()
        .getRetrofitInstance()
        .create(MovieService::class.java)

     fun getNowPlaying(){
        viewModelScope.launch {
            var response = retrofitinstance.getNowPlaying(apiKey)
            if (response.isSuccessful){
                movieLiveData.postValue(response.body()?.results)
            }
            else{
                errorLiveData.postValue("ApiError: ${response.code()}")
            }
        }
    }
     fun getPopular(){
        viewModelScope.launch {
            var response = retrofitinstance.getPopular(apiKey)
            if (response.isSuccessful){
                movieLiveData.postValue(response.body()?.results)
            }
            else{
                errorLiveData.postValue("ApiError: ${response.code()}")
            }
        }
    }
     fun getTopRated(){
        viewModelScope.launch {
            var response = retrofitinstance.getTopRated(apiKey)
            if (response.isSuccessful){
                movieLiveData.postValue(response.body()?.results)
            }
            else{
                errorLiveData.postValue("ApiError: ${response.code()}")
            }
        }
    }
     fun getUpcoming(){
        viewModelScope.launch {
            var response = retrofitinstance.getUpcoming(apiKey)
            if (response.isSuccessful){
                movieLiveData.postValue(response.body()?.results)
            }
            else{
                errorLiveData.postValue("ApiError: ${response.code()}")
            }
        }
    }
}