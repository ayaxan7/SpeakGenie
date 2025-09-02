package com.ayaan.speakgenie.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.ayaan.speakgenie.presentation.homescreen.HomeScreen
import com.ayaan.speakgenie.presentation.learnscreen.LearnScreen
import com.ayaan.speakgenie.presentation.membership.MembershipScreen
import com.ayaan.speakgenie.presentation.profilescreen.ProfileScreen

@Composable
fun AppNavigation() {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = Screen.Home.route) {
        composable(Screen.Home.route) {
            HomeScreen(navController)
        }
        composable(Screen.Learn.route) {
            LearnScreen(navController)
        }
        composable(Screen.Membership.route) {
            MembershipScreen(navController)
        }
        composable(Screen.Profile.route) {
            ProfileScreen(navController)
        }
    }
}