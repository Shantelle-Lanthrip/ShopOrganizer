package com.example.shoporganizer.navigation.screen

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.ui.graphics.vector.ImageVector
import com.example.shoporganizer.R

sealed class BottomNavItemScreen(val route: String, val icon: ImageVector, val title: Int) {
    object Home : BottomNavItemScreen("home_screen", Icons.Default.Home, R.string.bottom_nav_home)

    object Profile : BottomNavItemScreen("about_screen", Icons.Default.Person, R.string.bottom_nav_profile)
}