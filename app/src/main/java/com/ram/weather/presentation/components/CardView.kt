package com.ram.weather.presentation.components

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.ram.weather.ui.theme.getOnSurfaceColor
import com.ram.weather.ui.theme.getSurfaceColor

/**
 * @author ASUS
 * @date 28-05-2025
 */

@Composable
fun CardView(
    modifier: Modifier = Modifier,
    containerColor: Color = getSurfaceColor(),
    contentColor: Color = getOnSurfaceColor(),
    cornerRadius: Dp = 16.dp,
    elevation: Dp = 4.dp,
    content: @Composable () -> Unit
) {
    Card (
        modifier = modifier.shadow(elevation, RoundedCornerShape(cornerRadius)).padding(),
        shape = RoundedCornerShape(cornerRadius),
        colors = CardDefaults.cardColors(
            containerColor = containerColor,
            contentColor = contentColor
        )
    ) {
        content()
    }
}

