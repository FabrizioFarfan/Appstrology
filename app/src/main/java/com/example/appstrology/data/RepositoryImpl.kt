package com.example.appstrology.data

import android.util.Log
import com.example.appstrology.data.network.HoroscopeApiService
import com.example.appstrology.domain.Repository
import com.example.appstrology.domain.model.PredictionModel
import javax.inject.Inject

class RepositoryImpl@Inject constructor(  val apiService: HoroscopeApiService): Repository  {
    override suspend fun getPrediction(sign: String): PredictionModel? {
         runCatching { apiService.getHoroscope(sign) }
             .onSuccess { return it.toDomain() }
             .onFailure { Log.i("Fabri", "Ha ocurrido un error ${it.message}")	}
        return null
    }


}