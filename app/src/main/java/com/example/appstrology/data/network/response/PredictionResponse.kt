package com.example.appstrology.data.network.response

import com.example.appstrology.domain.model.PredictionModel
import com.google.gson.annotations.SerializedName

data class PredictionResponse(
    @SerializedName("date") val date: String,
    @SerializedName("horoscope") val horoscope: String,
    @SerializedName("sign") val sign: String ){

    fun toDomain() : PredictionModel = PredictionModel(
        horoscope = horoscope,
        sign = sign )

}