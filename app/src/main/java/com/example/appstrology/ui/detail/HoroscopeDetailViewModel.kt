package com.example.appstrology.ui.detail

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.appstrology.domain.model.HoroscopeModel
import com.example.appstrology.domain.usecase.GetPredictionUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import dagger.hilt.android.scopes.ViewModelScoped
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

@HiltViewModel
class HoroscopeDetailViewModel @Inject constructor(private val getPredictionUseCase: GetPredictionUseCase): ViewModel() {
    lateinit var horoscope: HoroscopeModel
    private var _state = MutableStateFlow<HoroscopeDetailState>(HoroscopeDetailState.Loading)
    val state: StateFlow<HoroscopeDetailState> = _state

    fun getHoroscope(sign: HoroscopeModel){
        horoscope = sign
        viewModelScope.launch{
            // hilo principal
            _state.value = HoroscopeDetailState.Loading
            val result = withContext(Dispatchers.IO){ getPredictionUseCase(sign.name) } //hilo secundario
            if( result != null){ // si es distinto a null va a settear este estado
                _state.value = HoroscopeDetailState.Success(result.horoscope, result.sign, horoscope)
            }else{ // si es null pues setteamos a el estado de error
                _state.value = HoroscopeDetailState.Error("Ha ocurrido un error")
            }
        }
    }


}