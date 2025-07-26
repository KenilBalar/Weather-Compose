package com.ram.weather.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

val LightPrimaryColor = Color(0xFFA3F0FF)
val LightOnPrimaryColor = Color(0xFF23272C)

val LightBackgroundColor = Color(0xFFFFFFFF)
val LightSurfaceColor = Color(0xFFDFEFFF)
val LightOnBackgroundColor = Color(0xFF23272C)
val LightOnSurfaceColor = Color(0xFF363636)

val LightDividerColor = Color(0xFFA2B7D2)

val LightRedColor = Color(0xFFFF4C4C)
val LightBlueColor = Color(0xFF2C99D7)


val DarkPrimaryColor = Color(0xFF22D3DD)
val DarkOnPrimaryColor = Color(0xFF23272C)

val DarkBackgroundColor = Color(0xFF23272C)
val DarkSurfaceColor = Color(0xFF1F2024)
val DarkOnBackgroundColor = Color(0xFFFFFFFF)
val DarkOnSurfaceColor = Color(0xFFFFFFFF)

val DarkDividerColor = Color(0xFF2D333A)

val DarkRedColor = Color(0xFFFF6A6A)
val DarkBlueColor = Color(0xFF69C9FF)

@Composable
fun getPrimaryColor() = MaterialTheme.colorScheme.primary

@Composable
fun getOnPrimaryColor() = MaterialTheme.colorScheme.onPrimary

@Composable
fun getBackgroundColor() = MaterialTheme.colorScheme.background

@Composable
fun getOnBackgroundColor() = MaterialTheme.colorScheme.onBackground

@Composable
fun getSurfaceColor() = MaterialTheme.colorScheme.surface

@Composable
fun getOnSurfaceColor() = MaterialTheme.colorScheme.onSurface

@Composable
fun getDividerColor() = MaterialTheme.colorScheme.outline

@Composable
fun getRedColor() = if (isSystemInDarkTheme()) DarkRedColor else LightRedColor

@Composable
fun getBlueColor() = if (isSystemInDarkTheme()) DarkBlueColor else LightBlueColor