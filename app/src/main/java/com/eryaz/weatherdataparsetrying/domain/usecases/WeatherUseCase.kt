package com.eryaz.weatherdataparsetrying.domain.usecases

import com.eryaz.weatherdataparsetrying.utils.Resource
import com.eryaz.weatherdataparsetrying.data.models.WeatherDataDto
import com.eryaz.weatherdataparsetrying.domain.repository.WeatherRepository
import javax.inject.Inject

class WeatherUseCase @Inject constructor(
   private val weatherRepository: WeatherRepository
){

    suspend fun getWeatherData(lat:Double, long:Double) : Resource<WeatherDataDto> {

        return try {
            Resource.Success(data = weatherRepository.getWeatherData(lat,long))

        } catch (e : Exception){
            Resource.Error(message = e.message?: "Error!")
        }
    }

}