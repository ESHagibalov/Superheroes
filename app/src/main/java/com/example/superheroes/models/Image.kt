package com.example.superheroes.models

import com.google.gson.annotations.SerializedName

data class Image(
    @SerializedName("url")
    var url: String
)
