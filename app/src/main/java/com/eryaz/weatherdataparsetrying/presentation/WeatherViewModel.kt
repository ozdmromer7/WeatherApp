package com.eryaz.weatherdataparsetrying.presentation

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.eryaz.weatherdataparsetrying.domain.usecases.WeatherUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class WeatherViewModel @Inject constructor(
    private val weatherUseCase: WeatherUseCase
): ViewModel() {

    private val _state = mutableStateOf(WeatherState())
        var state : State<WeatherState> = _state


    init {
       getWeatherData(43.0,52.0)
    }

    private fun getWeatherData(lat :Double,long:Double){

        viewModelScope.launch {
            val weather = weatherUseCase.getWeatherData(lat,long)
            _state.value = WeatherState(weatherData = weather.data)
        }

    }
}