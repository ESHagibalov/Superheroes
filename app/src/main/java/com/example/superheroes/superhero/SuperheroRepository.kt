package com.example.superheroes.superhero

import android.util.Log
import com.example.superheroes.internet.ApiService
import com.example.superheroes.internet.UserRequestApi
import com.example.superheroes.models.responses.*
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import java.lang.Exception

object SuperheroRepository{
    suspend fun getById():Flow<IdResponse> = flow{
        try {
            val result = ApiService.userApi.getById()

            emit(result)
        } catch (e: Exception) {
            Log.e("GetById exception", e.message.toString())
        }
    }

    suspend fun getByName(name: String):Flow<NameResponse> = flow{
        try {
            val result = ApiService.userApi.getByName(name)

            emit(result)
        } catch (e: Exception) {
            Log.e("GetById exception", e.message.toString())
        }
    }

    suspend fun gwtPowerstats():Flow<PowerstatsResponse> = flow{
        try {
            val result = ApiService.userApi.getPowerStats()

            emit(result)
        } catch (e: Exception) {
            Log.e("GetById exception", e.message.toString())
        }
    }

    suspend fun getBiography():Flow<BiographyResponse> = flow{
        try {
            val result = ApiService.userApi.getBiography()

            emit(result)
        } catch (e: Exception) {
            Log.e("GetById exception", e.message.toString())
        }
    }

    suspend fun getAppearance():Flow<AppearanceResponse> = flow{
        try {
            val result = ApiService.userApi.getAppearance()

            emit(result)
        } catch (e: Exception) {
            Log.e("GetById exception", e.message.toString())
        }
    }

    suspend fun getWork():Flow<WorkResponse> = flow{
        try {
            val result = ApiService.userApi.getWork()

            emit(result)
        } catch (e: Exception) {
            Log.e("GetById exception", e.message.toString())
        }
    }

    suspend fun getConnections():Flow<ConnectionsResponse> = flow{
        try {
            val result = ApiService.userApi.getConnections()

            emit(result)
        } catch (e: Exception) {
            Log.e("GetById exception", e.message.toString())
        }
    }

    suspend fun getImage():Flow<ImageResponse> = flow{
        try {
            val result = ApiService.userApi.getImage()

            emit(result)
        } catch (e: Exception) {
            Log.e("GetById exception", e.message.toString())
        }
    }
}