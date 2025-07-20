package com.ram.weather.utils

import com.ram.weather.data.dto.CurrentDto
import com.ram.weather.data.dto.DailyDto
import com.ram.weather.data.dto.HourlyDto
import com.ram.weather.data.dto.WeatherDto
import com.ram.weather.data.dto.WeatherTypeDto
import com.ram.weather.data.model.CurrentWeather
import com.ram.weather.data.model.DailyWeather
import com.ram.weather.data.model.HourlyWeather
import com.ram.weather.data.model.WeatherCondition
import com.ram.weather.data.model.WeatherInfo

/**
 * @author ASUS
 * @date 21-07-2025
 */
fun WeatherDto.toWeatherInfo(): WeatherInfo {
    return WeatherInfo(
        current = current.toCurrentWeather(),
        hourly = hourly.take(24).map { it.toHourlyWeather() },
        daily = daily.take(7).map { it.toDailyWeather() }
    )
}

fun CurrentDto.toCurrentWeather(): CurrentWeather {
    return CurrentWeather(
        time = dt,
        temperature = temp,
        feelsLike = feels_like,
        humidity = humidity,
        pressure = pressure,
        uvi = uvi,
        windSpeed = wind_speed,
        sunrise = sunrise,
        sunset = sunset,
        condition = weather.first().toWeatherCondition()
    )
}

fun HourlyDto.toHourlyWeather(): HourlyWeather {
    return HourlyWeather(
        time = dt,
        temperature = temp,
        condition = weather.first().toWeatherCondition()
    )
}

fun DailyDto.toDailyWeather(): DailyWeather {
    return DailyWeather(
        time = dt,
        minTemp = temp.min,
        maxTemp = temp.max,
        condition = weather.first().toWeatherCondition()
    )
}

fun WeatherTypeDto.toWeatherCondition(): WeatherCondition {
    return WeatherCondition(
        type = main,
        description = description,
        iconCode = icon
    )
}
