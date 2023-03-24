package com.rafli.weatherapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.compose.material.MaterialTheme
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.rafli.weather_list_presentation.WeatherListScreen
import com.rafli.core.navigation.Routes
import com.rafli.weatherapp.extension.navigateScreen
import dagger.hilt.android.AndroidEntryPoint

@ExperimentalComposeUiApi
@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MaterialTheme {
                val navController = rememberNavController()

                NavHost(
                    navController = navController,
                    startDestination = Routes.WEATHER_LIST
                ) {
                    // weather data screen navigation
                    composable(Routes.WEATHER_LIST) {
                        WeatherListScreen(onNavigate = navController::navigateScreen)
                    }
                }
            }
        }
    }
}