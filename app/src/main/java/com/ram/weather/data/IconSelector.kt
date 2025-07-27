package com.ram.weather.data

import com.ram.weather.R

/**
 * @author ASUS
 * @date 27-07-2025
 */
object IconSelector {

     private val SUN = R.drawable.ic_sun
     private val MOON = R.drawable.ic_moon
     private val CLOUD = R.drawable.ic_cloud
     private val RAIN = R.drawable.ic_rain
     private val RAIN_HEAVY = R.drawable.ic_rain_heavy
     private val RAIN_THUNDER = R.drawable.ic_thunder_rain
     private val THUNDER = R.drawable.ic_thunder
     private val SNOW = R.drawable.ic_snow
     private val PARTIALLY_CLOUDY_DAY = R.drawable.ic_sun_cloud
     private val PARTIALLY_CLOUDY_NIGHT = R.drawable.ic_moon_cloud
     private val WIND = R.drawable.ic_cloud_wind

    fun getIcon(iconCode : String) : Int{

        return when(iconCode){
            "01d" -> SUN
            "01n" -> MOON
            "02d" -> PARTIALLY_CLOUDY_DAY
            "02n" -> PARTIALLY_CLOUDY_NIGHT
            "03d" -> CLOUD
            "03n" -> CLOUD
            "04d" -> CLOUD
            "04n" -> CLOUD
            "09d" -> RAIN_HEAVY
            "09n" -> RAIN_HEAVY
            "10d" -> RAIN
            "10n" -> RAIN
            "11d" -> RAIN_THUNDER
            "11n" -> RAIN_THUNDER
            "13d" -> SNOW
            "13n" -> SNOW
            "50d" -> WIND
            "50n" -> WIND
            else -> PARTIALLY_CLOUDY_DAY
        }
    }
}