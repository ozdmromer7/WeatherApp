package com.eryaz.weatherdataparsetrying.domain.entities

import java.time.LocalDateTime

data class WeatherDataHourly(
    val time : LocalDateTime,
    val temperature : Double,
    val weatherCode : Int,
    val humidity : Int,
    val windSpeed : Double,
    val pressure : Double
)
