package com.rafli.weather_list_presentation.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.rafli.core.util.Resource
import com.rafli.weather_list_domain.model.WeatherData
import com.rafli.weather_list_domain.use_case.GetWeatherByCityUseCase
import com.rafli.weather_list_presentation.model.WeatherDataUiModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class WeatherListViewModel @Inject constructor(
    private val getWeatherByCityUseCase: GetWeatherByCityUseCase
): ViewModel() {

    private val _weatherData: MutableLiveData<WeatherDataUiModel?> = MutableLiveData(null)
    val weatherData: LiveData<WeatherDataUiModel?>
        get() = _weatherData

    fun getWeatherByCityName(cityName: String) {
        showLoading()
        viewModelScope.launch {
            when(val weatherDataResult = getWeatherByCityUseCase.invoke(cityName)) {
                is Resource.Success -> {
                    _weatherData.postValue(WeatherDataUiModel(
                        weatherData = weatherDataResult.data ?: WeatherData(),
                        isLoading = false,
                        isError = false
                    ))
                }
                is Resource.Error -> {
                    _weatherData.postValue(WeatherDataUiModel(
                        isLoading = false,
                        isError = true
                    ))
                }
            }
        }
    }

    private fun showLoading() {
        _weatherData.value = WeatherDataUiModel(isLoading = true, isError = false)
    }
}