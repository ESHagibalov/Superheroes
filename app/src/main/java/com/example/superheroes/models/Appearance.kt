package com.example.superheroes.models

import com.google.gson.annotations.SerializedName

data class Appearance(
    @SerializedName("gender")
    val gender: String,

    @SerializedName("race")
    val race: String,

    @SerializedName("height")
    val height: MutableList<String>,

    @SerializedName("weight")
    val weight: MutableList<String>,

    @SerializedName("eye-color")
    val eyeColor: String,

    @SerializedName("hair-color")
    val hairColor: String
)
