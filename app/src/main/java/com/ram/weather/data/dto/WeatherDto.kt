package com.ram.weather.data.dto

/**
 * @author ASUS
 * @date 21-07-2025
 */

data class WeatherDto(
    val lat: Double,
    val lon: Double,
    val timezone: String,
    val timezone_offset: Int,
    val current: CurrentDto,
    val hourly: List<HourlyDto>,
    val daily: List<DailyDto>
)

data class CurrentDto(
    val dt: Long,
    val sunrise: Long,
    val sunset: Long,
    val temp: Double,
    val feels_like: Double,
    val pressure: Int,
    val humidity: Int,
    val dew_point: Double,
    val uvi: Double,
    val clouds: Int,
    val visibility: Int,
    val wind_speed: Double,
    val wind_deg: Int,
    val wind_gust: Double,
    val weather: List<WeatherTypeDto>
)

data class HourlyDto(
    val dt: Long,
    val temp: Double,
    val feels_like: Double,
    val pressure: Int,
    val humidity: Int,
    val dew_point: Double,
    val uvi: Double,
    val clouds: Int,
    val visibility: Int,
    val wind_speed: Double,
    val wind_deg: Int,
    val wind_gust: Double,
    val weather: List<WeatherTypeDto>,
    val pop: Double,
    val rain: RainDto? = null
)

data class RainDto(
    val `1h`: Double
)

data class DailyDto(
    val dt: Long,
    val sunrise: Long,
    val sunset: Long,
    val moonrise: Long,
    val moonset: Long,
    val moon_phase: Double,
    val summary: String,
    val temp: DailyTempDto,
    val feels_like: DailyFeelsLikeDto,
    val pressure: Int,
    val humidity: Int,
    val dew_point: Double,
    val wind_speed: Double,
    val wind_deg: Int,
    val wind_gust: Double,
    val weather: List<WeatherTypeDto>,
    val clouds: Int,
    val pop: Double,
    val rain: Double? = null,
    val uvi: Double
)

data class DailyTempDto(
    val day: Double,
    val min: Double,
    val max: Double,
    val night: Double,
    val eve: Double,
    val morn: Double
)

data class DailyFeelsLikeDto(
    val day: Double,
    val night: Double,
    val eve: Double,
    val morn: Double
)

data class WeatherTypeDto(
    val id: Int,
    val main: String,
    val description: String,
    val icon: String
)
