package com.rafli.weatherapp.extension

import androidx.navigation.NavController
import com.rafli.core.util.UiEvent

/**
 * Nav controller extension function to navigate between screen (composable)
 */
fun NavController.navigateScreen(event: UiEvent.Navigate) {
    this.navigate(event.route)
}