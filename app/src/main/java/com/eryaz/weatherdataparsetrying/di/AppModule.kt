package com.eryaz.weatherdataparsetrying.di

import com.eryaz.weatherdataparsetrying.domain.repository.WeatherRepository
import com.eryaz.weatherdataparsetrying.data.remote.WeatherApi
import com.eryaz.weatherdataparsetrying.data.repository.WeatherRepositoryImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun funProvideWeatherApi() : WeatherApi {
        return Retrofit.Builder()
            .baseUrl("https://api.open-meteo.com/")
            .addConverterFactory(MoshiConverterFactory.create())
            .build()
            .create(WeatherApi::class.java)
    }

    @Provides
    @Singleton
    fun provideWeatherRepository(weatherApi: WeatherApi) : WeatherRepository {
        return  WeatherRepositoryImpl(weatherApi)
    }
}