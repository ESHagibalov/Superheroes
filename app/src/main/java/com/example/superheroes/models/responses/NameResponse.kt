package com.example.superheroes.models.responses

import com.example.superheroes.models.IdResult
import com.google.gson.annotations.SerializedName

data class NameResponse(
    @SerializedName("response")
    val response: String,

    @SerializedName("results-for")
    val resultsFor: String,

    @SerializedName("results")
    val idResults: MutableList<IdResult>,
)
