package com.ayaan.speakgenie.presentation.navigation

sealed class Screen(val route: String) {
    object Home : Screen("home")
    object Details : Screen("details")
}
