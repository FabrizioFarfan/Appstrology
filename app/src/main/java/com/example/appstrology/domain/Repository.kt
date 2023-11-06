package com.example.appstrology.domain

import com.example.appstrology.data.network.response.PredictionResponse
import com.example.appstrology.domain.model.PredictionModel

interface Repository {
    suspend fun getPrediction(sign: String): PredictionModel?
}