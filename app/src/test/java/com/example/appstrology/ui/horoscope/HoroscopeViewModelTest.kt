package com.example.appstrology.ui.horoscope

import com.example.appstrology.data.motherobject.AppstrologyMotherObject
import com.example.appstrology.data.providers.HoroscopeProvider
import io.mockk.MockKAnnotations
import io.mockk.every
import io.mockk.impl.annotations.MockK
import org.junit.Assert.*
import org.junit.Before
import org.junit.Test

class HoroscopeViewModelTest{


    @MockK
    lateinit var horoscopeProvider: HoroscopeProvider

    private lateinit var viewModel: HoroscopeViewModel

    @Before
    fun setUp(){

        MockKAnnotations.init(this, relaxUnitFun = true)
    }

    @Test
    fun when_viewmodel_is_createed_then_horoscopes_are_loaded(){

        every { horoscopeProvider.getHoroscopes() } returns AppstrologyMotherObject().horoscopeInfoList

        viewModel = HoroscopeViewModel(horoscopeProvider)



        val horoscopes = viewModel.horoscope.value

        //entonces el resultado no tiene q ser null
        assertTrue(horoscopes.isNotEmpty())
    }
}