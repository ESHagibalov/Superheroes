package com.example.superheroes.models.responses

import com.google.gson.annotations.SerializedName

data class ConnectionsResponse(
    @SerializedName("response")
    val response: String,

    @SerializedName("id")
    val id: String,

    @SerializedName("name")
    val name: String,

    @SerializedName("group-affiliation")
    val groupAffiliation: String,

    @SerializedName("relatives")
    val relatives: String
)

