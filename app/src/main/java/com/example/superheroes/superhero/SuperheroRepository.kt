package com.example.superheroes.superhero

import android.util.Log
import com.example.superheroes.internet.ApiService
import com.example.superheroes.internet.UserRequestApi
import com.example.superheroes.models.responses.*
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import java.lang.Exception

object SuperheroRepository{
    suspend fun getById(id: String):Flow<IdResponse> = flow{
        try {
            val result = ApiService.userApi.getById(id)
            Log.e("Result", ApiService.userApi.getById(id).toString())
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
            Log.e("GetByName exception", e.message.toString())
        }
    }
}