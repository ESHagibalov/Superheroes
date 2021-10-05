package com.example.superheroes.ui.superheroeslist

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.superheroes.internet.ApiService
import com.example.superheroes.models.Result
import com.example.superheroes.models.responses.NameResponse
import com.example.superheroes.superhero.SuperheroRepository
import com.example.superheroes.utils.CoroutineHelper
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import org.json.JSONObject

class SuperheroesViewModel : ViewModel() {
    val superheroes = MutableLiveData(arrayListOf<Result>())

    init {
        Log.e("view model", "init")
    }
    fun getSuperheroes(name: String) {
        CoroutineHelper.coroutineScope.launch {
            SuperheroRepository.getByName("search/${name}").collect {
                if (it.response == "success") {
                    parseRes(it)
                }
            }
        }
    }

    private fun parseRes(result: NameResponse) {
        val superheroesTmp = arrayListOf<Result>()
        var json: JSONObject
        Log.e("view model", "parsing")

        if (result.response == "success") {

            val resPojo = (result.results as List<*>)

            for (item in resPojo) {
//                Log.e("Im here", "eeeeee")
//                Log.e("nameResponse", result.results.toString())

                json = JSONObject(item as Map<*, *>)
                superheroesTmp.add(ApiService.gson.fromJson(json.toString(), Result::class.java))
            }

            try {
                Class.forName("dalvik.system.CloseGuard")
                    .getMethod("setEnabled", Boolean::class.javaPrimitiveType)
                    .invoke(null, true)
            } catch (e: ReflectiveOperationException) {
                throw RuntimeException(e)
            }
            for (item in superheroesTmp) {
                superheroes.value!!.add(item)

            }
        }
    }
}