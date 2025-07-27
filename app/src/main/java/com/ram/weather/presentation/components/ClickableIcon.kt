package com.ram.weather.presentation.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.ripple.rememberRipple
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage

/**
 * @author ASUS
 * @date 26-07-2025
 */
@Composable
fun ClickableImageView(
    drawableRes: Int,
    contentDescription: String? = null,
    alignment: Alignment = Alignment.Center,
    modifier: Modifier = Modifier.padding(8.dp),
    contentScale: ContentScale = ContentScale.Crop,
    colorFilter: ColorFilter? = null,
    onClick: () -> Unit
) {
    val shape = CircleShape // or RoundedCornerShape(12.dp)

    Surface(
        modifier = Modifier
            .clip(shape),
        shape = shape,
        color = Color.Transparent,
        onClick = onClick,
    ) {
        Image(
            painter = painterResource(id = drawableRes),
            contentDescription = contentDescription,
            modifier = modifier,
            alignment = alignment,
            contentScale = contentScale,
            colorFilter = colorFilter
        )
    }
}
