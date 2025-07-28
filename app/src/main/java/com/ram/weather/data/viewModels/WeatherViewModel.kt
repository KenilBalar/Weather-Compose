package com.ram.weather.data.viewModels

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ram.weather.data.model.CurrentWeather
import com.ram.weather.data.model.HourlyWeather
import com.ram.weather.data.repository.WeatherRepository
import com.ram.weather.utils.Utils
import com.ram.weather.utils.loadStaticWeatherInfo
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import java.util.Objects
import javax.inject.Inject

/**
 * @author ASUS
 * @date 27-07-2025
 */
@dagger.hilt.android.lifecycle.HiltViewModel
class WeatherViewModel @Inject constructor(
    private val weatherRepository: WeatherRepository
) : ViewModel() {

    private val _isLoading = MutableStateFlow(false)
    val isLoading: StateFlow<Boolean> = _isLoading.asStateFlow()

    private val _currentCity = MutableStateFlow("Düsseldorf")
    val currentCity: StateFlow<String> = _currentCity.asStateFlow()

    private val _currentWeather = MutableStateFlow<CurrentWeather>(CurrentWeather())
    val currentWeather: StateFlow<CurrentWeather> = _currentWeather.asStateFlow()

    private val _dailyForecast = MutableStateFlow<List<HourlyWeather>>(emptyList())
    val dailyForecast: StateFlow<List<HourlyWeather>> = _dailyForecast.asStateFlow()

    private val _hourlyForecast = MutableStateFlow<List<HourlyWeather>>(emptyList())
    val hourlyForecast: StateFlow<List<HourlyWeather>> = _hourlyForecast.asStateFlow()


//        Uncomment init block  if you want to fetch from API (API_KEY required)
//    init {
//        getWeatherData(52.558745,13.392946)
//    }


    //        Uncomment below function if you want to load static response similar to API (No API_KEY required)
    fun getStaticWeatherData(context: Context) {
        _isLoading.value = true
        val weatherInfo = context.loadStaticWeatherInfo()
        Utils.showLog(weatherInfo.toString(), "--STATIC-RESPONSE--->")
        viewModelScope.launch {
            delay(1500)
            withContext(Dispatchers.Main) {
                _isLoading.value = false
                _currentCity.value = "Berlin"
                _currentWeather.value = weatherInfo.current
                _hourlyForecast.value = weatherInfo?.hourly ?: emptyList()
            }

        }
    }

    fun getWeatherData(lat: Double, long: Double) {
        viewModelScope.launch {
            _isLoading.value = true
            try {
                val weatherInfo = weatherRepository.getWeatherData(lat, long)
                Utils.showLog(weatherInfo.toString(), "--API-RESPONSE--->")
                _currentCity.value = "Mülheim an der Ruhr"
                _currentWeather.value = weatherInfo.current
                _hourlyForecast.value = weatherInfo.hourly
            } catch (e: Exception) {
                Utils.showLog(e.message.toString(), "--API-FAILURE--->")
            } finally {
                _isLoading.value = false
            }
        }
    }
}
