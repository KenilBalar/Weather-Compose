package com.ram.weather.presentation.home

import android.app.Activity
import androidx.activity.compose.BackHandler
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberUpdatedState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext

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
    Box(Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
        Text("Welcome to Home")
    }
}