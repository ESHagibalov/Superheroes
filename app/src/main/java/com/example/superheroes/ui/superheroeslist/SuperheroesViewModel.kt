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
        if (result.response == "success") {

            val resPojo = (result.results as List<*>)

            for (item in resPojo) {

                json = JSONObject(item as Map<*, *>)
                Log.e("Im here", "eeeeee")

                superheroesTmp.add(ApiService.gson.fromJson(json.toString(), Result::class.java))
            }

            for (item in superheroesTmp) {
                superheroes.value!!.add(item)
            }
        }
    }
}