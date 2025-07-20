package com.ram.weather.presentation.splash

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import kotlinx.coroutines.delay

/**
 * @author ASUS
 * @date 21-07-2025
 */
@Composable
fun SplashScreen(onNavigate: () -> Unit) {
    LaunchedEffect(true) {
        delay(2000L) // simulate loading
        onNavigate()
    }

    Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
        Text("Weather App", style = MaterialTheme.typography.headlineMedium)
    }
}