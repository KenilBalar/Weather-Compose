package com.ram.weather.data.repository

import com.ram.weather.data.remote.WeatherApi
import com.ram.weather.data.model.WeatherInfo
import com.ram.weather.utils.toWeatherInfo
import com.ram.weather.utils.API_KEY
import javax.inject.Inject

/**
 * @author ASUS
 * @date 21-07-2025
 */
class WeatherRepositoryImpl @Inject constructor(
    private val api: WeatherApi
) : WeatherRepository {
    override suspend fun getWeatherData(lat: Double, lon: Double): WeatherInfo {
        return api.getWeatherData(lat, lon, API_KEY).toWeatherInfo()
    }
}