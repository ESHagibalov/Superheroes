package com.example.superheroes.internet

import com.example.superheroes.utils.Constants
import com.example.superheroes.models.responses.*
import retrofit2.http.GET
import retrofit2.http.Part
import retrofit2.http.Path
import retrofit2.http.Url

interface UserRequestApi {
    @GET
    suspend fun getById(@Url id: String): IdResponse

    @GET
    suspend fun getByName(@Url name: String): NameResponse

}