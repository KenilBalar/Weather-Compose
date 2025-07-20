package com.ram.weather.data.dto

/**
 * @author ASUS
 * @date 21-07-2025
 */
data class WeatherDto(
    val lat: Double,
    val lon: Double,
    val timezone: String,
    val current: CurrentDto,
    val hourly: List<HourlyDto>,
    val daily: List<DailyDto>
)

data class CurrentDto(
    val dt: Long,
    val temp: Double,
    val feels_like: Double,
    val pressure: Int,
    val humidity: Int,
    val wind_speed: Double,
    val uvi: Double,
    val sunrise: Long,
    val sunset: Long,
    val weather: List<WeatherTypeDto>
)

data class HourlyDto(
    val dt: Long,
    val temp: Double,
    val weather: List<WeatherTypeDto>
)

data class DailyDto(
    val dt: Long,
    val temp: DailyTempDto,
    val weather: List<WeatherTypeDto>
)

data class DailyTempDto(
    val day: Double,
    val min: Double,
    val max: Double
)

data class WeatherTypeDto(
    val main: String,
    val description: String,
    val icon: String
)
