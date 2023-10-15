package com.example.shoporganizer.navigation.graph

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.shoporganizer.navigation.screen.Screen
import com.example.shoporganizer.presentation.screen.MainScreen
import com.example.shoporganizer.presentation.screen.splash.SplashScreen

@Composable
fun RootNavGraph(navController: NavHostController) {
    NavHost(
        navController = navController,
        route = Graph.ROOT,
        startDestination = Screen.Splash.route
    ) {
        composable(route = Screen.Splash.route) {
            SplashScreen(navController = navController)
        }

        composable(route = Graph.MAIN) {
            MainScreen()
        }
    }
}