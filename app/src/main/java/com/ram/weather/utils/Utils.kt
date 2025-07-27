package com.ram.weather.utils

import android.util.Log

/**
 * @author ASUS
 * @date 27-07-2025
 */
object Utils {
    fun showLog(message : String, key: String = ">>--GOT-LOG--->>>"){
        Log.e(key,message)
    }
}