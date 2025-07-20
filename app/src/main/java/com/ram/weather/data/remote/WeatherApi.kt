package com.ram.weather.data.remote

import com.ram.weather.data.dto.WeatherDto
import retrofit2.http.GET
import retrofit2.http.Query

/**
 * @author ASUS
 * @date 21-07-2025
 */
interface WeatherApi {
    @GET("onecall")
    suspend fun getWeatherData(
        @Query("lat") lat: Double,
        @Query("lon") lon: Double,
        @Query("appid") apiKey: String,
        @Query("exclude") exclude: String = "minutely,alerts",
        @Query("units") units: String = "metric"
    ): WeatherDto
}