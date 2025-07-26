package com.ram.weather.presentation.home

import android.app.Activity
import androidx.activity.compose.BackHandler
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberUpdatedState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.sp
import com.ram.weather.presentation.components.TextMedium
import com.ram.weather.ui.theme.getSurfaceColor

/**
 * @author ASUS
 * @date 21-07-2025
 */
@Composable
fun HomeScreen() {
    val context = LocalContext.current
    val backPressed = rememberUpdatedState {
        (context as? Activity)?.finish()
    }

    BackHandler {
        backPressed.value()
    }

    // Your home UI
    Box(
        Modifier
            .fillMaxSize()
            .background(getSurfaceColor()), contentAlignment = Alignment.Center
    ) {
        TextMedium("Welcome to home screen", fontSize = 16.sp)
    }
}