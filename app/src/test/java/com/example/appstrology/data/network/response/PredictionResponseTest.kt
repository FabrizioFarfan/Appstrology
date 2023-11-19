package com.example.appstrology.data.network.response

import com.example.appstrology.data.motherobject.AppstrologyMotherObject
import io.kotlintest.shouldBe
import org.junit.Assert.*
import org.junit.Test

class PredictionResponseTest{

    @Test //NO OLVIDAR ESTA ANNOTATION
    fun toDomain_Should_Return_A_Correct_PredictionModel(){

        //Given
        val horoscopeResponse = AppstrologyMotherObject().anyResponse

        //When (CUANDO OCURRA LA ACCION Q QUIERO TESTEAR)
        val predictionModel = horoscopeResponse.toDomain()

        //Then
        predictionModel.sign shouldBe horoscopeResponse.sign
        predictionModel.horoscope shouldBe horoscopeResponse.horoscope

    }


}