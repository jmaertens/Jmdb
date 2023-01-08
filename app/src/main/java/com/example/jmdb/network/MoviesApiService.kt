package com.example.jmdb.network

import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.scalars.ScalarsConverterFactory
import retrofit2.http.GET


//https://api.themoviedb.org/3/discover/movie?api_key=dd66da20608e332b5fb77e67e213f143

private const val BASE_URL = "https://api.themoviedb.org/3/discover/movie/"
private const val KEY = "dd66da20608e332b5fb77e67e213f143"

//Use Retrofit Builder with ScalarsConverterFactory and base_url
private val retrofit = Retrofit.Builder()
    .addConverterFactory(ScalarsConverterFactory.create())
    .baseUrl(BASE_URL)
    .build()

//Implement MoviesApiService interface with @GET getProperties returning a String
interface MoviesApiService{
    @GET("?api_key=$KEY")
    fun getProperties():
            Call<String>
}

//Create an object called MoviesApi to access the RetrofitService
//Lazy means it will only be initialized when it is first accessed (from retrofit)
object MoviesApi{
    val retrofitService : MoviesApiService by lazy {
        retrofit.create(MoviesApiService::class.java)
    }
}