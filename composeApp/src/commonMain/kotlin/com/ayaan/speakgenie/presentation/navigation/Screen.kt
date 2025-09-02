package com.ayaan.speakgenie.presentation.navigation

sealed class Screen(val route: String) {
    object Home : Screen("home")
    object Learn : Screen("learn")
    object Membership : Screen("membership")
    object Profile : Screen("profile")
}
