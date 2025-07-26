package com.ram.weather.presentation.components

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.sp
import com.ram.weather.ui.theme.PoppinsRegular
import com.ram.weather.ui.theme.getOnSurfaceColor

/**
 * @author ASUS
 * @date 26-07-2025
 */

@Composable
fun TextRegular(
    text: Any,
    modifier: Modifier = Modifier,
    fontSize : TextUnit = 12.sp,
    color: Color = getOnSurfaceColor(),
    textAlign: TextAlign = TextAlign.Start,
    maxLines: Int = Int.MAX_VALUE,
    overflow: TextOverflow = TextOverflow.Clip
) {
    Text(
        text =  if (text is Int)stringResource(id = text) else text.toString(),
        modifier = modifier,
        color = color,
        fontSize = fontSize,
        fontFamily = PoppinsRegular,
        textAlign = textAlign,
        maxLines = maxLines,
        overflow = overflow
    )
}