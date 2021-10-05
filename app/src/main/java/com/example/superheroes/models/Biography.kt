package com.example.superheroes.models

import com.google.gson.annotations.SerializedName

data class Biography(
    @SerializedName("full-name")
    var fullName: String,

    @SerializedName("alter-egos")
    val alterEgos: String,

    @SerializedName("aliases")
    var aliases: List<String>,

    @SerializedName("place-of-birth")
    val placeOfBirth: String,

    @SerializedName("first-appearance")
    val firstAppearance: String,

    @SerializedName("publisher")
    val publisher: String,

    @SerializedName("alignment")
    val alignment: String
)
