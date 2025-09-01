package com.ayaan.speakgenie.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.ayaan.speakgenie.presentation.homescreen.HomeScreen

@Composable
fun AppNavigation() {
    val navController= rememberNavController()
    NavHost(navController=navController, startDestination = Screen.Home.route){
        composable(Screen.Home.route){
            HomeScreen(navController)
        }
    }
}