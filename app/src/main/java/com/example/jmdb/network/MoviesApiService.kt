package com.example.jmdb.network

import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import kotlinx.coroutines.Deferred
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.GET

//Example get discover first 10 movies
//https://api.themoviedb.org/3/discover/movie?api_key=dd66da20608e332b5fb77e67e213f143

//Example get poster details (narnia)
//https://image.tmdb.org/t/p/original/iREd0rNCjYdf5Ar0vfaW32yrkm.jpg

private const val BASE_URL = "https://api.themoviedb.org/3/discover/movie/"
private const val KEY = "dd66da20608e332b5fb77e67e213f143"

//Using Moshi builder to create a moshi object
private val moshi = Moshi.Builder()
    .add(KotlinJsonAdapterFactory())
    .build()

//Using Retrofit Builder with ScalarsConverterFactory and base_url
private val retrofit = Retrofit.Builder()
    .addConverterFactory(MoshiConverterFactory.create(moshi))
    //Allows to replace the Call adapter for supporting service method return types other than Call (Coroutine Deferred)
    .addCallAdapterFactory(CoroutineCallAdapterFactory())
    .baseUrl(BASE_URL)
    .build()

//Implement MoviesApiService interface with @GET getProperties returning a String
interface MoviesApiService{
    @GET("?api_key=$KEY")
    fun getProperties():
            Deferred<MoviesProperty>
    //Defered is a job that can directly return a value/result, await async
}

//Create an object called MoviesApi to access the RetrofitService
//Lazy means it will only be initialized when it is first accessed (from retrofit)
object MoviesApi{
    val retrofitService : MoviesApiService by lazy {
        retrofit.create(MoviesApiService::class.java)
    }
}