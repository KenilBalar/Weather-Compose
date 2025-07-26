package com.ram.weather.presentation.components

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import com.ram.weather.ui.theme.getOnSurfaceColor

/**
 * @author ASUS
 * @date 26-07-2025
 */

@Composable
fun TextView(
    text: String,
    modifier: Modifier = Modifier,
    styleType: TextStyleType = TextStyleType.LabelMedium,
    color: Color = getOnSurfaceColor(),
    textAlign: TextAlign = TextAlign.Start,
    maxLines: Int = Int.MAX_VALUE,
    overflow: TextOverflow = TextOverflow.Clip
) {
    val textStyle = styleType.toTextStyle()
    Text(
        text = text,
        modifier = modifier,
        color = color,
        fontSize = textStyle.fontSize,
        fontWeight = textStyle.fontWeight,
        fontFamily = textStyle.fontFamily,
        lineHeight = textStyle.lineHeight,
        textAlign = textAlign,
        maxLines = maxLines,
        overflow = overflow
    )
}

sealed class TextStyleType {
    object Title : TextStyleType()
    object LabelSmall : TextStyleType()
    object LabelMedium : TextStyleType()
    object LabelLarge : TextStyleType()
}

@Composable
fun TextStyleType.toTextStyle(): TextStyle {
    return when (this) {
        is TextStyleType.Title -> MaterialTheme.typography.titleMedium
        is TextStyleType.LabelSmall -> MaterialTheme.typography.labelSmall
        is TextStyleType.LabelMedium -> MaterialTheme.typography.labelMedium
        is TextStyleType.LabelLarge -> MaterialTheme.typography.labelLarge
    }
}