package com.ram.weather.utils

import com.ram.weather.data.dto.*
import com.ram.weather.data.model.*

fun WeatherDto.toWeatherInfo(): WeatherInfo {
    val todayDto = daily.firstOrNull()
    return WeatherInfo(
        timezone = timezone,
        timezoneOffset = timezone_offset,
        current = current.toCurrentWeather(),
        today = todayDto?.toTodayWeather() ?: TodayWeather(),     // ⬅️ new
        hourly = hourly.take(24).map { it.toHourlyWeather() },
        daily = daily.take(7).map { it.toDailyWeather() }
    )
}

fun DailyDto.toTodayWeather(): TodayWeather {
    val w = weather.firstOrNull()
    return TodayWeather(
        time = dt,
        sunrise = sunrise,
        sunset = sunset,
        summary = summary,
        minTemp = temp.min,
        maxTemp = temp.max,
        dayTemp = temp.day,
        dewPoint = dew_point,
        pressure = pressure,
        humidity = humidity,
        windSpeed = wind_speed,
        windDeg = wind_deg,
        windGust = wind_gust,
        clouds = clouds,
        uvi = uvi,
        pop = pop,
        rain = rain ?: 0.0,
        condition = WeatherCondition(
            type = w?.main.orEmpty(),
            description = w?.description.orEmpty(),
            iconCode = w?.icon.orEmpty()
        )
    )
}

// (Keep the rest from your previous mapper)
private fun WeatherTypeDto?.toWeatherConditionSafe(): WeatherCondition =
    WeatherCondition(
        type = this?.main.orEmpty(),
        description = this?.description.orEmpty(),
        iconCode = this?.icon.orEmpty()
    )

fun CurrentDto.toCurrentWeather(): CurrentWeather {
    val w = weather.firstOrNull()
    return CurrentWeather(
        time = dt,
        temperature = temp,
        feelsLike = feels_like,
        humidity = humidity,
        pressure = pressure,
        uvi = uvi,
        windSpeed = wind_speed,
        windDeg = wind_deg,
        windGust = wind_gust,
        sunrise = sunrise,
        sunset = sunset,
        dewPoint = dew_point,
        clouds = clouds,
        visibility = visibility,
        condition = w.toWeatherConditionSafe()
    )
}

fun HourlyDto.toHourlyWeather(): HourlyWeather {
    val w = weather.firstOrNull()
    return HourlyWeather(
        time = dt,
        temperature = temp,
        feelsLike = feels_like,
        pressure = pressure,
        humidity = humidity,
        dewPoint = dew_point,
        uvi = uvi,
        clouds = clouds,
        visibility = visibility,
        windSpeed = wind_speed,
        windDeg = wind_deg,
        windGust = wind_gust,
        pop = pop,
        rain1h = rain?.`1h` ?: 0.0,
        condition = w.toWeatherConditionSafe()
    )
}

fun DailyDto.toDailyWeather(): DailyWeather {
    val w = weather.firstOrNull()
    return DailyWeather(
        time = dt,
        sunrise = sunrise,
        sunset = sunset,
        summary = summary,
        dayTemp = temp.day,
        minTemp = temp.min,
        maxTemp = temp.max,
        feelsLikeDay = feels_like.day,
        feelsLikeNight = feels_like.night,
        feelsLikeEve = feels_like.eve,
        feelsLikeMorn = feels_like.morn,
        pressure = pressure,
        humidity = humidity,
        dewPoint = dew_point,
        windSpeed = wind_speed,
        windDeg = wind_deg,
        windGust = wind_gust,
        clouds = clouds,
        uvi = uvi,
        pop = pop,
        rain = rain ?: 0.0,
        condition = w.toWeatherConditionSafe()
    )
}
