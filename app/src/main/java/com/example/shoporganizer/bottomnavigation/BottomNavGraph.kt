package com.example.shoporganizer.bottomnavigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.shoporganizer.home.HomeScreen
import com.example.shoporganizer.profile.ProfileScreen

@Composable
fun BottomNavGraph(navController: NavHostController){
    NavHost(
        navController = navController,
        startDestination = "home_screen"
    ){
        composable(route = "home_screen"){
            HomeScreen()
        }
        composable(route = "profile_screen"){
            ProfileScreen()
        }
    }
}