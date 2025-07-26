package com.ram.weather.presentation.components

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

/**
 * @author ASUS
 * @date 28-05-2025
 */

@Composable
fun SpaceVertical(space: Int){
    Spacer(modifier = Modifier.height(space.dp))
}

@Composable
fun SpaceHorizontal(space: Int){
    Spacer(modifier = Modifier.width(space.dp))
}