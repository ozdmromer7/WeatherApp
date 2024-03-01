package com.eryaz.weatherdataparsetrying.data.repository

import com.eryaz.weatherdataparsetrying.data.models.WeatherDataDto
import com.eryaz.weatherdataparsetrying.data.remote.WeatherApi
import com.eryaz.weatherdataparsetrying.domain.repository.WeatherRepository
import javax.inject.Inject

class WeatherRepositoryImpl @Inject constructor(
    private val weatherApi : WeatherApi
) : WeatherRepository {
    override suspend fun getWeatherData(latitude: Double, longitude: Double): WeatherDataDto {

        return weatherApi.getWeatherData(latitude,longitude)
    }


}