package com.example.shoporganizer.presentation.screen

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Scaffold
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.shoporganizer.navigation.graph.MainNavGraph
import com.example.shoporganizer.presentation.component.BottomNavBar

@Composable
fun MainScreen(
    navController: NavHostController = rememberNavController()
) {
    Scaffold(
        bottomBar = {
            Surface() {
                BottomNavBar(navController = navController)
            }
        },
    ) {
        Column(
            modifier = Modifier.padding(it)
        ) {
            MainNavGraph(navController = navController)
        }
    }
}