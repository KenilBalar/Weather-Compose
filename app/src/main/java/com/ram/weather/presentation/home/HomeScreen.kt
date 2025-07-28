package com.ram.weather.presentation.home

import android.app.Activity
import androidx.activity.compose.BackHandler
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberUpdatedState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.composed
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.hilt.navigation.compose.hiltViewModel
import com.ram.weather.R
import com.ram.weather.data.IconSelector
import com.ram.weather.data.viewModels.WeatherViewModel
import com.ram.weather.presentation.components.ClickableImageView
import com.ram.weather.presentation.components.ImageView
import com.ram.weather.presentation.components.SpaceHorizontal
import com.ram.weather.presentation.components.TextBold
import com.ram.weather.presentation.components.TextMedium
import com.ram.weather.ui.theme.getOnSurfaceColor
import com.ram.weather.ui.theme.getSurfaceColor
import com.ram.weather.utils.Utils
import com.ram.weather.utils.showToast

/**
 * @author ASUS
 * @date 21-07-2025
 */

@Composable
fun HomeScreen() {
    val context = LocalContext.current
    val backPressed = rememberUpdatedState {
        (context as? Activity)?.finish()
    }
    BackHandler {
        backPressed.value()
    }
    HomeUI()
}

@Composable
fun HomeUI(viewModel: WeatherViewModel = hiltViewModel()) {
    Utils.showLog("HomeUi Refreshed...")
    Box(
        Modifier
            .fillMaxSize()
            .background(getSurfaceColor())
    ) {
        viewModel.getStaticWeatherData(context = LocalContext.current)
        TemperatureSegment()
    }
}

@Preview(showBackground = true)
@Composable
fun TemperatureSegment(viewModel: WeatherViewModel = hiltViewModel()) {
    val loading = viewModel.isLoading.collectAsState()
    Utils.showLog("TemperatureSegment Refreshed...")

    if (loading.value) {
        Utils.showLog("API Calling...")
    } else {
        Utils.showLog("Data Fetched!")
    }
    Column {
        TopBar()
        WeatherInfoSection()
    }
}

@Preview(showBackground = true)
@Composable
fun TopBar(viewModel: WeatherViewModel = hiltViewModel()) {
    var context = LocalContext.current
    val currentCity = viewModel.currentCity.collectAsState()

    Utils.showLog("TopBar Updated...")
    Utils.showLog("Current City ==> ${currentCity.value}")

    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween,
        modifier = Modifier
            .fillMaxWidth()
            .padding(start = 10.dp, top = 40.dp, end = 10.dp, bottom = 20.dp)
    )
    {
        Button(
            colors = ButtonDefaults.buttonColors(containerColor = getSurfaceColor(), contentColor = getOnSurfaceColor()),
            onClick = {  },
        ) {
            TextMedium(currentCity.value, fontSize = 20.sp)
            SpaceHorizontal(6)
            ImageView(R.drawable.ic_drop_down, contentDescription = "Dropdown", colorFilter = ColorFilter.tint(getOnSurfaceColor()))
        }
        ClickableImageView(
            drawableRes = R.drawable.ic_settings,
            alignment = Alignment.CenterEnd
        ) {

        }
    }
}

@Preview(showBackground = true)
@Composable
fun WeatherInfoSection(viewModel: WeatherViewModel = hiltViewModel()){
    var currentWeather = viewModel.currentWeather.collectAsState()
    var currentWeatherData = currentWeather.value
    Box(modifier = Modifier.padding(horizontal = 20.dp)) {
        ConstraintLayout {
            val (ivWeather, tvCurrentTemp, tvHighTemp, tvLowTemp, tvWeatherInfo, tvFeelsLike) = createRefs()
            ImageView(
                modifier = Modifier.size(96.dp).constrainAs(ivWeather) { top.linkTo(parent.top) }
                    .constrainAs(ivWeather) { start.linkTo(parent.start) },
                drawable = IconSelector.getIcon(currentWeatherData.condition.iconCode)
            )

            TextBold(text = currentWeatherData.temperature.toString().plus("°C"), fontSize = 32.sp,
                modifier = Modifier.padding(start = 12.dp, top = 10.dp).constrainAs(tvCurrentTemp) { start.linkTo(ivWeather.end) }
                    .constrainAs(tvCurrentTemp) { top.linkTo(ivWeather.top) })>
        }
    }
}

@Preview(showBackground = true)
@Composable
fun HomePreview() {
    HomeUI()
}