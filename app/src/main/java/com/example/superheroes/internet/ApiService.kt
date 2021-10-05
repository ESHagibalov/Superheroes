package com.example.superheroes.internet

import com.example.superheroes.utils.Constants
import com.example.superheroes.internet.ApiService.gson
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

private val client = getInterceptorClient()

private val retrofit = Retrofit.Builder()
    .baseUrl(Constants.URL_BASE)
    .client(client)
    .addConverterFactory(GsonConverterFactory.create(gson))
    .addCallAdapterFactory(CoroutineCallAdapterFactory())
    .build()

private fun getInterceptorClient(): OkHttpClient {
    val interceptor = HttpLoggingInterceptor()
    interceptor.level = HttpLoggingInterceptor.Level.BODY

    return OkHttpClient.Builder()
        .addInterceptor(interceptor)
        .readTimeout(30, TimeUnit.SECONDS)
        .connectTimeout(30, TimeUnit.SECONDS)
        .build()
}

object ApiService {
    val gson: Gson by lazy {
        GsonBuilder().setLenient().create()
    }

    val userApi: UserRequestApi by lazy {
        retrofit.create(UserRequestApi::class.java)
    }
}