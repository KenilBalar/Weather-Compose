package com.ram.weather.data.model

/**
 * @author ASUS
 * @date 21-07-2025
 */
data class WeatherInfo(
    val current: CurrentWeather = CurrentWeather(),
    val hourly: List<HourlyWeather> = emptyList<HourlyWeather>(),
    val daily: List<DailyWeather> = emptyList<DailyWeather>()
)

data class CurrentWeather(
    val time: Long = 0L,
    val temperature: Double = 0.0,
    val feelsLike: Double = 0.0,
    val humidity: Int = 0,
    val pressure: Int = 0,
    val uvi: Double = 0.0,
    val windSpeed: Double = 0.0,
    val sunrise: Long = 0L,
    val sunset: Long = 0L,
    val condition: WeatherCondition = WeatherCondition()
)

data class HourlyWeather(
    val time: Long = 0L,
    val temperature: Double = 0.0,
    val condition: WeatherCondition = WeatherCondition()
)

data class DailyWeather(
    val time: Long = 0L,
    val minTemp: Double = 0.0,
    val maxTemp: Double = 0.0 ,
    val condition: WeatherCondition = WeatherCondition()
)

data class WeatherCondition(
    val type: String = "",
    val description: String = "",
    val iconCode: String = ""
)
