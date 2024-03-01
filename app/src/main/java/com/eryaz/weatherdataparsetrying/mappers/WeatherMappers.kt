package com.eryaz.weatherdataparsetrying.mappers

import com.eryaz.weatherdataparsetrying.data.models.WeatherDataDto
import com.eryaz.weatherdataparsetrying.data.models.WeatherDataHourlyDto
import com.eryaz.weatherdataparsetrying.domain.entities.WeatherDataHourly
import com.eryaz.weatherdataparsetrying.domain.entities.WeatherInfo
import java.time.LocalDateTime

private data class IndexedWeatherData(
    val index : Int,
    val data : WeatherDataHourly
)

fun WeatherDataHourlyDto.toWeatherDataHourlyMap() : Map<Int,List<WeatherDataHourly>> {

    return time.mapIndexed { index, time ->
        val temperature = temperatures[index]
        val weatherCode = weatherCodes[index]
        val windSpeed = windSpeeds[index]
        val pressure = pressures[index]
        val humidity = humidities[index]

        IndexedWeatherData(
            index = index,
            data = WeatherDataHourly(
                time = LocalDateTime.parse(time),
                temperature = temperature,
                pressure = pressure,
                windSpeed = windSpeed,
                humidity = humidity,
                weatherCode = weatherCode
            )
        )
    }.groupBy {
        it.index / 24
    }.mapValues {
        it.value.map { indexedData ->
            indexedData.data }
    }

}

fun WeatherDataDto.toWeatherInfo() : WeatherInfo {

    val weatherDataMap = weatherDataHourly.toWeatherDataHourlyMap()
    val now = LocalDateTime.now()

    val currentWeatherData = weatherDataMap[0]?.find {
        val hour = if(now.minute<30) now.hour else now.hour + 1
        it.time.hour ==hour
    }

    return WeatherInfo(
        weatherDataMap,
        currentWeatherData
    )

}