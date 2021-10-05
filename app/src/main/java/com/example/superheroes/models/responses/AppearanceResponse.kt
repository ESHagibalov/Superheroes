package com.example.superheroes.models.responses

import com.google.gson.annotations.SerializedName

data class AppearanceResponse(
    @SerializedName("response")
    val response: String,

    @SerializedName("id")
    val id: String,

    @SerializedName("name")
    val name: String,

    @SerializedName("gender")
    val gender: String,

    @SerializedName("race")
    val race: String,

    @SerializedName("height")
    val height: List<String>,

    @SerializedName("weight")
    val weight: List<String>,

    @SerializedName("eye-color")
    val eyeColor: String,

    @SerializedName("hair-color")
    val hairColor: String
)
