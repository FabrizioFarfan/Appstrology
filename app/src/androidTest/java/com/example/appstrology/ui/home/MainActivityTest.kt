package com.example.appstrology.ui.home

import androidx.test.espresso.contrib.RecyclerViewActions
import androidx.recyclerview.widget.RecyclerView

import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click

import androidx.test.espresso.intent.Intents
import androidx.test.espresso.intent.Intents.intended
import androidx.test.espresso.intent.matcher.IntentMatchers.hasComponent
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.example.appstrology.ui.detail.HoroscopeDetailActivity
import com.example.appstrology.R
import dagger.hilt.android.testing.HiltAndroidRule
import dagger.hilt.android.testing.HiltAndroidTest
import org.junit.After
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@HiltAndroidTest
@RunWith(AndroidJUnit4::class)
class MainActivityTest{
    //PARA HACER UI TESTING NECESITAMOS DE ESTAS REGLAS PARA CONFIGURAR EL TEST COMO SE DEBE
    //CON ESTA EXPRESION ESTAMOS PRERPARANDO PA INJECTAR ESTA CLASE O PUEDA INJECTAR COSAS
    //TENEMOS Q EXPECIFICAR SIEMPRE Q DAGGER HILT VA PRIMERO EN EL "order"
    @get:Rule(order = 0) //EMPIEZA X 0
    val hiltRule = HiltAndroidRule(this)

    //PARA Q HAGA TEST CON LA CLASE MAIN ACTIVITY NECESITAMOS INSTANCIARLA ASI
    //ESTO DEFINE LA CLASE Q ESTAMOS TESTEANDO Y NO OLVIDEN EL "order"
    @get:Rule(order = 1)
    var mainActivityRule = ActivityScenarioRule(MainActivity::class.java)

    //PARA Q TODO FUNCIONE NECESITAMOS ESTA FUN PARA HACER CONFIGURACIONES ESPECIALES
    @Before
    fun setUp(){
        //INJECTAMOS ESTO
        hiltRule.inject()
        //TENEMOS Q PREPAR LOS INTENT PARA TRABAJR CON ELLOS
        Intents.init()
    }

    @After// SE EJECUTA SIEMPRE DESPUES Q HAGAMOS TEST
    fun tearDown(){
        //PARA BORRAR TODOS LOS INTENT Q CREAMOS PARA LOS TEST Y ASI EVITAR PROBLEMAS
        Intents.release()
    }

    //CON ESTE TEST UI COMPROBAMOS Q LUCKFRAGMENT SE CREA CUANDO CREAMOS EL MAINACTIVITY
    @Test
    fun when_mainactivity_is_created_then_open_luck_fragment(){

        onView(withId(R.id.luckFragment)).perform(click())
    }

    //SE USA MUCHO ESTE TEST, COMPROBAR Q CUANDO PULSAMOS EN UN SITIO EN ESPECIFICO
    //LANZAMOS	LA ACTIVITY CORRECTA, TEST SENCILLO Q TENEMOS Q PREPARAR EN NUESTRAS APPS
    /***MUY IMPORTANTEE VISTO Q TIENE ALGUNAS ANIMACIONES CUANDO ABRIMOS ESTA PANTALLA
    ***CAUSA DELAY Y POR ESO CAUSA PROBLEMAS ,LA SOLUCION ES DESDE EL EEMULADOR DEL MOVIL
    ***DESACTIVARLOO DESDE EL SETTING->SYSETM->ABOUT EMULATED DEVICE->BUILD NUMBER(CLICKKK)
    ***DESPUES DE DARLE CLIC 5 VECES REGRESAMOS Y NOS SALE UNA NUEVA OPCION DONDE ENTRAMOS
    ***->DEVELOPER OPTIONS AQUI BUSCAMOS ANIMATION Y DESACTIVAMOS 1.WINDOW ANIMATION SCALE
    ***2.ANIMATOR DURATION SCALE Y 3.TRANSITION ANIMATION SCALE*/
    @Test
    fun when_horoscope_is_selected_then_open_detail(){
        //BUSCAME EL RECYCLERVIEW Y HACEMOS UN PERFORM(NO UN CLICK PORQ ES UN RV)
        onView(withId(R.id.rvHoroscope)).perform(
            RecyclerViewActions.actionOnItemAtPosition<RecyclerView.ViewHolder>(
                0, //Con este codigo decimos q va a coger el item 0
                click() //y le vas hacer un click
            )
        )
        //Entonces comprueba q ha habido un test q tiene un intent q tiene un component
        //con la informacion a donde va a navegar(HoroscopeDetailActivity) cuando clicko
        //como se supone q tiene q hacer en la app y gracias a la dependenecia de intent
        intended(hasComponent(HoroscopeDetailActivity::class.java.name))
    }
}