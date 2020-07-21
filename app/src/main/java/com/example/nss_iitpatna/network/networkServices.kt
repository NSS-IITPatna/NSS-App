package com.example.nss_iitpatna.network

import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import kotlinx.coroutines.Deferred
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.GET

//Dummy Data
private const val BASE_URL = "https://api.jsonbin.io/b/"

private val moshi = Moshi.Builder()
    .add(KotlinJsonAdapterFactory())
    .build()

private val retrofit = Retrofit.Builder()
    .addConverterFactory(MoshiConverterFactory.create(moshi))
    .addCallAdapterFactory(CoroutineCallAdapterFactory())
    .baseUrl(BASE_URL)
    .build()

interface NetworkService {
    @GET("5f168331c58dc34bf5d7a185/1")
    fun getImagesAsync():
            Deferred<List<Gallery>>
}

data class Gallery(var imageUrl: String, var label: String)

object Api {
    val networkService: NetworkService by lazy {
        retrofit.create(NetworkService::class.java)
    }
}