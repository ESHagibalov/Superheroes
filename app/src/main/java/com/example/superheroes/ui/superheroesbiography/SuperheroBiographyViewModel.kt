package com.example.superheroes.ui.superheroesbiography

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.superheroes.internet.ApiService
import com.example.superheroes.models.Result
import com.example.superheroes.models.responses.IdResponse
import com.example.superheroes.superhero.SuperheroRepository
import com.example.superheroes.utils.CoroutineHelper
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import org.json.JSONObject

class SuperheroBiographyViewModel: ViewModel() {
    var superhero = MutableLiveData<Result>()
    var id: Int = 1
    fun getSuperhero(id: Int) {
        CoroutineHelper.coroutineScope.launch {
            SuperheroRepository.getById(id.toString()).collect {
                if (it.response == "success") {
                    Log.e("view model superhero", it.image.url)

                    superhero.value!!.image.url = it.image.url
                    superhero.value!!.name = it.name.first().toString()
                    superhero.value!!.work.occupation = it.work.occupation.first().toString()
                    superhero.value!!.biography.fullName = it.biography.fullName.first().toString()
                    superhero.value!!.biography.aliases = listOf(it.biography.aliases.first().toString())
                    superhero.value!!.connections.relatives = it.connections.relatives.first().toString()

                }
            }
        }
    }
}