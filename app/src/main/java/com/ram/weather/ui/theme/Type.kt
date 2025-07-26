package com.ram.weather.ui.theme

import androidx.compose.material3.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.ram.weather.R


val PoppinsRegular = FontFamily(
    Font(R.font.poppins_regular, FontWeight.Normal)
)

val PoppinsMedium = FontFamily(
    Font(R.font.poppins_medium, FontWeight.Medium)
)

val PoppinsBold = FontFamily(
    Font(R.font.poppins_bold, FontWeight.Bold)
)

val Typography = Typography(
    labelSmall = TextStyle(fontFamily = PoppinsRegular, fontSize = 12.sp),
    labelMedium = TextStyle(fontFamily = PoppinsRegular,  fontSize = 14.sp),
    labelLarge = TextStyle(fontFamily = PoppinsRegular,  fontSize = 16.sp),
    titleSmall = TextStyle(fontFamily = PoppinsMedium,  fontSize = 14.sp),
    titleMedium = TextStyle(fontFamily = PoppinsMedium,  fontSize = 16.sp),
    titleLarge = TextStyle(fontFamily = PoppinsMedium,  fontSize = 18.sp),
    headlineSmall = TextStyle(fontFamily = PoppinsBold,  fontSize = 16.sp),
    headlineMedium = TextStyle(fontFamily = PoppinsBold,  fontSize = 18.sp),
    headlineLarge = TextStyle(fontFamily = PoppinsBold,  fontSize = 20.sp),
)

