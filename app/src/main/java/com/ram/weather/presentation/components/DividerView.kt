package com.ram.weather.presentation.components

import androidx.compose.material3.HorizontalDivider
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.ram.weather.ui.theme.getDividerColor

/**
 * @author ASUS
 * @date 26-07-2025
 */
@Composable
fun DividerView(
    modifier: Modifier = Modifier,
    color: Color = getDividerColor(),
    thickness: Dp = 1.dp
) {
    HorizontalDivider(
        color = color,
        thickness = thickness,
        modifier = modifier,
    )
}