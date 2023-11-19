package com.example.appstrology.data.motherobject

import com.example.appstrology.data.network.response.PredictionResponse
import com.example.appstrology.domain.model.HoroscopeInfo.*

class AppstrologyMotherObject {

    val anyResponse = PredictionResponse("date", "prediction", "taurus")

    val horoscopeInfoList = listOf( Aries,
        Taurus,
        Gemini,
        Cancer,
        Leo,
        Virgo,
        Libra,
        Scorpio,
        Sagittarius,
        Capricorn,
        Aquarius,
        Pisces
    )
}