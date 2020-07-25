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
    @GET("5f168331c58dc34bf5d7a185/3")
    fun getImagesAsync():
            Deferred<List<Gallery>>

    @GET("5f1a1a54c58dc34bf5d984d1/2")
    fun getTeamAsync():
            Deferred<List<Team>>

    @GET("5f1bd521c58dc34bf5da4c55/2")
    fun getEventsAsync():
            Deferred<List<Event>>
}

data class Gallery(var imageUrl: String, var label: String)

data class Team(
    var name: String,
    var designation: String,
    var imageUrl: String,
    var facebookLink: String,
    var twitterLink: String,
    var instagramLink: String
)

data class Event(
    var date: Long,
    var imageUrl: String,
    var title: String,
    var description: String,
    var link: String
)

object Api {
    val networkService: NetworkService by lazy {
        retrofit.create(NetworkService::class.java)
    }
}