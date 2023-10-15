package com.example.shoporganizer.navigation.screen

sealed class Screen(val route: String) {
    object Splash : Screen("splash_screen")

    object Details : Screen("details_screen/{itemId}") {
        fun passItemId(itemId: Int): String = "details_screen/$itemId"
    }
}