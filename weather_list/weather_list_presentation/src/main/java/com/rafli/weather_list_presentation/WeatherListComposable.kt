package com.rafli.weather_list_presentation

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import com.rafli.core.util.UiEvent
import com.rafli.weather_list_domain.model.WeatherData
import com.rafli.weather_list_presentation.util.toCelsius
import com.rafli.weather_list_presentation.util.unixTimestampToDateTimeString
import com.rafli.weather_list_presentation.viewmodel.WeatherListViewModel

@Composable
fun LoadingView(isShow: Boolean = false) {
    if (isShow) {
        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            CircularProgressIndicator(modifier = Modifier.size(48.dp))
            Spacer(modifier = Modifier.padding(vertical = 8.dp))
            Text(text = "Loading data...")
        }
    }
}

@ExperimentalComposeUiApi
@Composable
fun SearchInputView(viewModel: WeatherListViewModel) {
    var textFieldValue by remember { mutableStateOf(TextFieldValue("")) }
    val keyboardController = LocalSoftwareKeyboardController.current
    val searchInputModifier = Modifier
        .fillMaxWidth()
        .padding(4.dp)
    OutlinedTextField(
        value = textFieldValue,
        singleLine = true,
        label = { Text(text = "Cari Nama Kota...") },
        onValueChange = {
            textFieldValue = it
        },
        modifier = searchInputModifier,
        keyboardOptions = KeyboardOptions(imeAction = ImeAction.Search),
        keyboardActions = KeyboardActions(onSearch = {
            viewModel.getWeatherByCityName(textFieldValue.text)
            keyboardController?.hide()
        })
    )
}

@ExperimentalComposeUiApi
@Composable
fun WeatherItemView(
    onNavigate: (UiEvent.Navigate) -> Unit,
    weatherData: WeatherData
) {
    Card(elevation = 3.dp, modifier = Modifier
        .fillMaxWidth()
        .padding(0.dp)
        .padding(4.dp)
    ) {
        Row(modifier = Modifier.padding(12.dp), verticalAlignment = Alignment.Top) {
            Column(modifier = Modifier.padding(horizontal = 12.dp)) {
                Text(
                    text = "${weatherData.cityName} (${weatherData.dt.unixTimestampToDateTimeString()})",
                    fontWeight = FontWeight.Bold,
                    fontSize = 16.sp
                )
                Text(
                    text = "Status : ${weatherData.weatherStatus}",
                )
                Text(
                    text = "Temp: ${weatherData.temperature.toCelsius()} Deg (Celsius)",
                )
                Text(
                    text = "Humidity: ${weatherData.humidity}",
                )
            }
        }
    }
}

@ExperimentalComposeUiApi
@Composable
fun WeatherListScreen(
    onNavigate: (UiEvent.Navigate) -> Unit,
    viewModel: WeatherListViewModel = hiltViewModel()
) {
    MaterialTheme {

        val weatherDataUiModel = viewModel.weatherData.observeAsState().value

        Column(modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)) {

            // Loading View
            LoadingView(weatherDataUiModel?.isLoading ?: false)

            // search view
            SearchInputView(viewModel)

            // Search result
            if (weatherDataUiModel != null) {
                WeatherItemView(onNavigate = onNavigate, weatherData = weatherDataUiModel.weatherData)
            }
        }
    }
}