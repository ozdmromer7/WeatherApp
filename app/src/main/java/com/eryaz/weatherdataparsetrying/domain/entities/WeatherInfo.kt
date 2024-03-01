package com.eryaz.weatherdataparsetrying.domain.entities

data class WeatherInfo(
    val weatherDataPerDay: Map<Int, List<WeatherDataHourly>>,
    val currentWeatherData: WeatherDataHourly?
)
