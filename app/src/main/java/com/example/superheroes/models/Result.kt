package com.example.superheroes.models

import com.google.gson.annotations.SerializedName

data class Result (
    @SerializedName("id")
    var id: String,

    @SerializedName("name")
    val name: String,

    @SerializedName("powerstats")
    val powerStats: Powerstats,

    @SerializedName("biography")
    val biography: Biography,


    @SerializedName("appearance")
    val appearance: Appearance,

    @SerializedName("work")
    val work: Work,

    @SerializedName("connections")
    val connections: Connections,

    @SerializedName("image")
    val image: Image
)