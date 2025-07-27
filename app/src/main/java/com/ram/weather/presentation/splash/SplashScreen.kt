package com.ram.weather.presentation.splash

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.ram.weather.R
import com.ram.weather.presentation.components.ImageView
import com.ram.weather.presentation.components.TextMedium
import com.ram.weather.ui.theme.getDividerColor
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
    SplashUI()
}

@Composable
fun SplashUI(){
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(getSurfaceColor())
            .padding(30.dp),
        contentAlignment = Alignment.Center
    ) {
        ImageView(R.drawable.ic_sun_cloud,
            modifier = Modifier.size(200.dp))
        TextMedium(R.string.app_name,
            fontSize = 32.sp, color = getDividerColor(),
            modifier = Modifier.align(Alignment.BottomCenter))
    }
}


@Preview(showBackground = true)
@Composable
fun SplashPreview() {
    SplashUI()
}