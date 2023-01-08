package com.example.jmdb.screens.overviewmovies

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.jmdb.network.MoviesApi
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class OverviewMoviesViewModel : ViewModel() {

    // The internal MutableLiveData String that stores the status of the most recent request
    private val _response = MutableLiveData<String>()

    // The external immutable LiveData for the request status String
    val response: LiveData<String>
        get() = _response


    //Call getMoviesOverview() on init so we can display status immediately.
    init {
        getMoviesOverview()
    }


    //Sets the value of the status LiveData to the Movies API status.
    private fun getMoviesOverview() {
        //Call the MoviesApi to enqueue the Retrofit request, implementing the callbacks
        MoviesApi.retrofitService.getProperties().enqueue(object : Callback<String> {
            override fun onFailure(call: Call<String>, t: Throwable) {
                _response.value = "Failure: " + t.message
            }

            override fun onResponse(call: Call<String>, response: Response<String>) {
                _response.value = response.body()
            }
        })
        _response.value = "Set the movies API Response here!"
    }
}