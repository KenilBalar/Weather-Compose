package com.ram.weather.presentation.splash

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.sp
import com.ram.weather.R
import com.ram.weather.presentation.components.TextBold
import com.ram.weather.ui.theme.getSurfaceColor
import kotlinx.coroutines.delay

/**
 * @author ASUS
 * @date 21-07-2025
 */
@Composable
fun SplashScreen(onNavigate: () -> Unit) {
    LaunchedEffect(true) {
        delay(1000L) // simulate loading
        onNavigate()
    }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(getSurfaceColor()), contentAlignment = Alignment.Center
    ) {
        TextBold(R.string.app_name, fontSize = 32.sp)
    }
}