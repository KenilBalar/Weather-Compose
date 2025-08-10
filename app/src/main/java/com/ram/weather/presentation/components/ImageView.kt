package com.ram.weather.presentation.components

import androidx.compose.foundation.Image
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import coil.compose.AsyncImage
import com.ram.weather.ui.theme.getOnSurfaceColor

/**
 * @author ASUS
 * @date 26-07-2025
 */
@Composable
fun ImageView(
    drawable: Int,
    modifier: Modifier = Modifier,
    contentDescription: String? = null,
    alignment: Alignment = Alignment.Center,
    contentScale: ContentScale = ContentScale.Crop,
    colorFilter: ColorFilter? = null
) {
    Image(
        painter = painterResource(drawable),
        contentDescription = contentDescription,
        alignment = alignment,
        modifier = modifier,
        contentScale = contentScale,
        colorFilter = colorFilter
    )
}