package com.ram.weather.utils

import android.content.Context
import android.widget.Toast

/**
 * @author ASUS
 * @date 20-07-2025
 */
fun Context.showToast(message : String) {
    Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
}