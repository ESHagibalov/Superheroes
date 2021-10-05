package com.example.superheroes.models

import com.google.gson.annotations.SerializedName

data class Work(
    @SerializedName("occupation")
    var occupation: String,

    @SerializedName("base")
    val base: String
)
