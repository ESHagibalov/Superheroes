package com.example.superheroes.models.responses

import com.google.gson.annotations.SerializedName

data class BiographyResponse(
    @SerializedName("response")
    val response: String,

    @SerializedName("id")
    val id: String,

    @SerializedName("name")
    val name: String,

    @SerializedName("full-name")
    val fullName: String,

    @SerializedName("alter-egos")
    val alterEgos: String,

    @SerializedName("aliases")
    val aliases: List<String>,

    @SerializedName("place-of-birth")
    val placeOfBirth: String,

    @SerializedName("first-appearance")
    val firstAppearance: String,

    @SerializedName("publisher")
    val publisher: String,

    @SerializedName("alignment")
    val alignment: String
)
