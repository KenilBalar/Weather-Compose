package com.ram.weather.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.ram.weather.presentation.home.HomeScreen
import com.ram.weather.presentation.splash.SplashScreen

/**
 * @author ASUS
 * @date 20-07-2025
 */
@Composable
fun AppNavigation(navController: NavHostController) {
    NavHost(navController = navController, startDestination = Screen.SPLASH) {
        composable(Screen.SPLASH) {
            SplashScreen(onNavigate = {
                navController.popBackStack()
                navController.navigate(Screen.HOME)
            })
        }
        composable(Screen.HOME) {
            HomeScreen()
        }
    }
}