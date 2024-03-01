package com.eryaz.weatherdataparsetrying.domain.repository

import com.eryaz.weatherdataparsetrying.data.models.WeatherDataDto

interface WeatherRepository {

    suspend fun getWeatherData(latitude : Double, longitude : Double) : WeatherDataDto
}