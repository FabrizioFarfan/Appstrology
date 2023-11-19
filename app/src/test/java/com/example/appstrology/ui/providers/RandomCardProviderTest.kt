package com.example.appstrology.ui.providers

import org.junit.Assert.*
import org.junit.Test

class RandomCardProviderTest{
    @Test
    fun getRandomCard_Should_Return_a_Random_Card() {
        // AQUI ESTAMOS CREANDO Y DANDO EL OBJETO RandomCardProvider (Given)
        val randomCard = RandomCardProvider()

        //ESTE ES MI "When" , CUANDO YO LLAME ESTA FUNCION
        val card = randomCard.getLucky()

        //ENTONCES(Then) NOS ASEGURAMOS QUE ESTA CONDICION SEA CORRECTA
        assertNotNull(card)

    }
}