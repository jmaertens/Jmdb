package com.example.jmdb.screens.overviewmovies

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.jmdb.network.MoviesApi
import com.example.jmdb.network.MoviesProperty
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class OverviewMoviesViewModel : ViewModel() {

    // The internal MutableLiveData String that stores the status of the most recent request
    private val _response = MutableLiveData<String>()

    // The external immutable LiveData for the request status String
    val response: LiveData<String>
        get() = _response

    //Coroutine job
    private var viewModelJob = Job()
    private val coroutineScope = CoroutineScope(viewModelJob + Dispatchers.Main)


    //Call getMoviesOverview() on init so we can display status immediately.
    init {
        getMoviesOverview()
    }




    //Sets the value of the status LiveData to the Movies API status.
    private fun getMoviesOverview() {
        coroutineScope.launch {
            var getPropertiesDeferred = MoviesApi.retrofitService.getProperties().await()
            try {
                var listResult = getPropertiesDeferred
                _response.value = "Succes: ${listResult?.results?.size} Movies properties retrieved"
            } catch (e: Exception){
                _response.value = "Failure: " + e.message
            }
        }
    }

    //Cancel Coroutine when the ViewModel finished on onCleared
    override fun onCleared() {
        super.onCleared()
        viewModelJob.cancel()
    }
}