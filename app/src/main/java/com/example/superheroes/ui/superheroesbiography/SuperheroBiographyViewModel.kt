package com.example.superheroes.ui.superheroesbiography

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.superheroes.internet.ApiService
import com.example.superheroes.models.Biography
import com.example.superheroes.models.IdResult
import com.example.superheroes.models.responses.IdResponse
import com.example.superheroes.superhero.SuperheroRepository
import com.example.superheroes.utils.CoroutineHelper
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import org.json.JSONObject

class SuperheroBiographyViewModel(): ViewModel() {
    val superhero = MutableLiveData<IdResult>()
    var id: Int = 0
    fun getSuperhero() {
        CoroutineHelper.coroutineScope.launch {
            SuperheroRepository.getById(id.toString()).collect {
                if (it.response == "success") {
                    parseRes(it)
                }
            }
        }
    }

    private fun parseRes(idResponse: IdResponse) {
        val aliasesTmp = arrayListOf<String>()
        var json: JSONObject
        if (idResponse.response == "success") {
            val aliasesPojo = (idResponse.biography.aliases as Map<*, *>)["aliases"] as List<*>
            for (item in aliasesPojo) {
                json = JSONObject(item as Map<*, *>)

                aliasesTmp.add(ApiService.gson.fromJson(json.toString(), String::class.java))
            }

            for (item in aliasesTmp) {
                superhero.value!!.biography.aliases.add(item)
            }
        }
    }
}