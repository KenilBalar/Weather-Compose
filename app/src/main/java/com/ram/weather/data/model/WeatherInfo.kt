package com.ram.weather.data.model

/**
 * @author ASUS
 * @date 21-07-2025
 */
data class WeatherInfo(
    val timezone: String = "",
    val timezoneOffset: Int = 0,
    val current: CurrentWeather = CurrentWeather(),
    val today: TodayWeather = TodayWeather(),
    val hourly: List<HourlyWeather> = emptyList(),
    val daily: List<DailyWeather> = emptyList()
)

data class TodayWeather(
    val time: Long = 0L,
    val sunrise: Long = 0L,
    val sunset: Long = 0L,
    val summary: String = "",
    val minTemp: Double = 0.0,
    val maxTemp: Double = 0.0,
    val dayTemp: Double = 0.0,
    val dewPoint: Double = 0.0,
    val pressure: Int = 0,
    val humidity: Int = 0,
    val windSpeed: Double = 0.0,
    val windDeg: Int = 0,
    val windGust: Double = 0.0,
    val clouds: Int = 0,
    val uvi: Double = 0.0,
    val pop: Double = 0.0,
    val rain: Double = 0.0,
    val condition: WeatherCondition = WeatherCondition()
)
data class CurrentWeather(
    val time: Long = 0L,
    val temperature: Double = 0.0,
    val feelsLike: Double = 0.0,
    val humidity: Int = 0,
    val pressure: Int = 0,
    val uvi: Double = 0.0,
    val windSpeed: Double = 0.0,
    val windDeg: Int = 0,
    val windGust: Double = 0.0,
    val sunrise: Long = 0L,
    val sunset: Long = 0L,
    val dewPoint: Double = 0.0,
    val clouds: Int = 0,
    val visibility: Int = 0,
    val condition: WeatherCondition = WeatherCondition()
)

data class HourlyWeather(
    val time: Long = 0L,
    val temperature: Double = 0.0,
    val feelsLike: Double = 0.0,
    val pressure: Int = 0,
    val humidity: Int = 0,
    val dewPoint: Double = 0.0,
    val uvi: Double = 0.0,
    val clouds: Int = 0,
    val visibility: Int = 0,
    val windSpeed: Double = 0.0,
    val windDeg: Int = 0,
    val windGust: Double = 0.0,
    /** Probability of precipitation (0.0..1.0) */
    val pop: Double = 0.0,
    /** Rain volume for the last hour if present */
    val rain1h: Double = 0.0,
    val condition: WeatherCondition = WeatherCondition()
)

data class DailyWeather(
    val time: Long = 0L,
    val sunrise: Long = 0L,
    val sunset: Long = 0L,
    val summary: String = "",
    val dayTemp: Double = 0.0,
    val minTemp: Double = 0.0,
    val maxTemp: Double = 0.0,
    val feelsLikeDay: Double = 0.0,
    val feelsLikeNight: Double = 0.0,
    val feelsLikeEve: Double = 0.0,
    val feelsLikeMorn: Double = 0.0,
    val pressure: Int = 0,
    val humidity: Int = 0,
    val dewPoint: Double = 0.0,
    val windSpeed: Double = 0.0,
    val windDeg: Int = 0,
    val windGust: Double = 0.0,
    val clouds: Int = 0,
    val uvi: Double = 0.0,
    val pop: Double = 0.0,
    /** Total rain for the day (mm) if present */
    val rain: Double = 0.0,
    val condition: WeatherCondition = WeatherCondition()
)

data class WeatherCondition(
    val type: String = "",
    val description: String = "",
    val iconCode: String = ""
)
