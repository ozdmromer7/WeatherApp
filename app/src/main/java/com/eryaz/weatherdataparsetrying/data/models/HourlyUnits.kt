package com.eryaz.weatherdataparsetrying.data.models

import com.squareup.moshi.Json

data class HourlyUnits(

    @field:Json(name = "time")
    val time : String ,

    @field:Json(name = "temperature_2m")
    val temperature :String ,

    @field:Json(name = "weathercode")
    val weatherCode : String,

    @field:Json(name = "relativehumidity_2m")
    val relativeHumidity : String,

    @field:Json(name = "windspeed_10m")
    val windSpeed : String,

    @field:Json(name = "pressure_msl")
    val pressure : String
)