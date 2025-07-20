package com.ram.weather.data.repository

import com.ram.weather.data.model.WeatherInfo

/**
 * @author ASUS
 * @date 21-07-2025
 */
interface WeatherRepository {
    suspend fun getWeatherData(lat: Double, lon: Double): WeatherInfo
}
