package com.eryaz.weatherdataparsetrying.data.models

import com.squareup.moshi.Json

data class WeatherDataHourlyDto(

    @field:Json(name = "time")
    val time : List<String>,

    @field:Json(name = "temperature_2m")
    val temperatures : List<Double>,

    @field:Json(name = "weathercode")
    val weatherCodes : List<Int>,

    @field:Json(name = "relativehumidity_2m")
    val humidities : List<Int>,

    @field:Json(name = "windspeed_10m")
    val windSpeeds : List<Double>,

    @field:Json(name = "pressure_msl")
    val pressures : List<Double>

)

