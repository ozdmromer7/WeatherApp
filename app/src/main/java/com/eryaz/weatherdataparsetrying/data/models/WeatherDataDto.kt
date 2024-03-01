package com.eryaz.weatherdataparsetrying.data.models

import com.squareup.moshi.Json

data class WeatherDataDto(

    val latitude :Double,

    val longitude :Double,

    @field:Json(name = "generationtime_ms")
    val generationTime : Double,

    @field:Json(name="hourly_units")
    val hourlyUnits : HourlyUnits,

    @field:Json(name = "hourly")
    val weatherDataHourly : WeatherDataHourlyDto

)
