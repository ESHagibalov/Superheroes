package com.example.superheroes.models.responses

import com.google.gson.annotations.SerializedName

data class WorkResponse(
    @SerializedName("response")
    val response: String,

    @SerializedName("id")
    val id: String,

    @SerializedName("name")
    val name: String,

    @SerializedName("occupation")
    val occupation: String,

    @SerializedName("base")
    val base: String
)