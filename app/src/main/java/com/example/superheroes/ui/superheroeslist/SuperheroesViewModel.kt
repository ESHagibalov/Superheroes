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
                } else {
                    superheroes.postValue(null)
                }
            }
        }
    }

    private fun parseRes(result: NameResponse) {
        superheroes.postValue(result.results as ArrayList<Result>?)
    }
}