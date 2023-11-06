package com.example.appstrology.domain.usecase

import com.example.appstrology.domain.Repository
import com.example.appstrology.domain.model.PredictionModel
import javax.inject.Inject

class GetPredictionUseCase @Inject constructor(private val repository: Repository) {
    suspend operator fun invoke(sign: String) = repository.getPrediction(sign)

}