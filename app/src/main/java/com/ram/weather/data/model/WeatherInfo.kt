package com.ram.weather.data.model

/**
 * @author ASUS
 * @date 21-07-2025
 */
data class WeatherInfo(
    val current: CurrentWeather,
    val hourly: List<HourlyWeather>,
    val daily: List<DailyWeather>
)

data class CurrentWeather(
    val time: Long,
    val temperature: Double,
    val feelsLike: Double,
    val humidity: Int,
    val pressure: Int,
    val uvi: Double,
    val windSpeed: Double,
    val sunrise: Long,
    val sunset: Long,
    val condition: WeatherCondition
)

data class HourlyWeather(
    val time: Long,
    val temperature: Double,
    val condition: WeatherCondition
)

data class DailyWeather(
    val time: Long,
    val minTemp: Double,
    val maxTemp: Double,
    val condition: WeatherCondition
)

data class WeatherCondition(
    val type: String,
    val description: String,
    val iconCode: String
)
