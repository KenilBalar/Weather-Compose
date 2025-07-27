package com.ram.weather.utils

import android.content.Context
import android.widget.Toast
import com.ram.weather.R
import com.ram.weather.data.dto.WeatherDto
import com.ram.weather.data.model.WeatherInfo
import com.squareup.moshi.Moshi

/**
 * @author ASUS
 * @date 20-07-2025
 */
fun Context.showToast(message : String) {
    Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
}

fun Context.loadStaticWeatherInfo(): WeatherInfo? {
    return try {
        val inputStream = resources.openRawResource(R.raw.static_weather_response)
        val json = inputStream.bufferedReader().use { it.readText() }

        val moshi = Moshi.Builder().build()
        val adapter = moshi.adapter(WeatherDto::class.java)

        adapter.fromJson(json)?.toWeatherInfo()
    } catch (e: Exception) {
        e.printStackTrace()
        null
    }
}