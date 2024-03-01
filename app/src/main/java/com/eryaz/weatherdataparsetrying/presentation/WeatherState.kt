package com.eryaz.weatherdataparsetrying.presentation

import com.eryaz.weatherdataparsetrying.data.models.WeatherDataDto

data class WeatherState(
    val isLoading:Boolean = false,
    val weatherData: WeatherDataDto? = null
)
