package com.example.superheroes.internet

import com.example.superheroes.utils.Constants
import com.example.superheroes.models.responses.*
import retrofit2.http.GET
import retrofit2.http.Part
import retrofit2.http.Path
import retrofit2.http.Url

interface UserRequestApi {
    @GET(Constants.URL_ID)
    suspend fun getById(): IdResponse

    @GET
    suspend fun getByName(@Url name: String): NameResponse

    @GET(Constants.URL_POWERSTATS)
    suspend fun getPowerStats(): PowerstatsResponse

    @GET(Constants.URL_BIOGRAPHY)
    suspend fun getBiography(): BiographyResponse

    @GET(Constants.URL_APPEARANCE)
    suspend fun getAppearance(): AppearanceResponse

    @GET(Constants.URL_WORK)
    suspend fun getWork(): WorkResponse

    @GET(Constants.URL_CONNECTIONS)
    suspend fun getConnections(): ConnectionsResponse

    @GET(Constants.URL_IMAGE)
    suspend fun getImage(): ImageResponse

}