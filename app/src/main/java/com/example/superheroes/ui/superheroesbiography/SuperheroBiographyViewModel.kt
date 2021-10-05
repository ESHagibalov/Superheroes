package com.example.superheroes.ui.superheroesbiography

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.superheroes.models.Result
import com.example.superheroes.superhero.SuperheroRepository
import com.example.superheroes.utils.CoroutineHelper
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

class SuperheroBiographyViewModel : ViewModel() {
    var superhero = MutableLiveData<Result>()
    var id: Int = 1
    fun getSuperhero(id: Int) {
        CoroutineHelper.coroutineScope.launch {
            SuperheroRepository.getById(id.toString()).collect {
                if (it.response == "success") {
                    superhero.postValue(
                        Result(
                            it.id,
                            it.name,
                            it.powerStats,
                            it.biography,
                            it.appearance,
                            it.work,
                            it.connections,
                            it.image
                        )
                    )
                }
            }
        }
    }
}