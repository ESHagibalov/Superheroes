package com.example.superheroes.models.responses

import com.google.gson.annotations.SerializedName

data class ImageResponse(
    @SerializedName("response")
    val response: String,

    @SerializedName("id")
    val id: String,

    @SerializedName("name")
    val name: String,

    @SerializedName("url")
    val url: String
)
