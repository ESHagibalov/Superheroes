package com.example.superheroes.utils

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job

object CoroutineHelper {

    var viewModelJob = Job()
    val coroutineScope = CoroutineScope(
        viewModelJob + Dispatchers.Main
    )
}
