package com.ram.weather.utils

import android.os.Build
import android.util.Log
import java.text.SimpleDateFormat
import java.time.Instant
import java.time.format.DateTimeFormatter
import java.util.Date
import java.util.Locale

/**
 * @author ASUS
 * @date 27-07-2025
 */
object Utils {
    fun showLog(message: String, key: String = ">>--GOT-LOG--->>>") {
        Log.e(key, message)
    }

    fun formatTimeFromEpoch(
        epochSeconds: Long,
        use24h: Boolean,
        locale: Locale = Locale.getDefault()
    ): String {
        val pattern = if (use24h) "HH:mm" else "hh:mm a"

            return SimpleDateFormat(pattern,locale).format(Date(epochSeconds*1000))

    }

    fun isOrAboveAndroid8(): Boolean {
        return Build.VERSION.SDK_INT >= Build.VERSION_CODES.O
    }

}