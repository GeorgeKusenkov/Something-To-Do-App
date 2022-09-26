package com.example.somethingtodo.data.api

import com.example.somethingtodo.data.randomActivityModel.RandomActivityModel
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

private const val BASE_URL = "https://www.boredapi.com"

object RetrofitServices {
    private val retrofit = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    val somethingToDoApi: SomethingToDoApi = retrofit.create(
        SomethingToDoApi::class.java
    )
}

interface SomethingToDoApi {
    @GET("/api/activity/")
    suspend fun getActivity(): RandomActivityModel
}