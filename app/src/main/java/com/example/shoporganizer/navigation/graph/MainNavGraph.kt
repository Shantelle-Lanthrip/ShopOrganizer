package com.example.shoporganizer.navigation.graph

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import androidx.navigation.navigation
import com.example.shoporganizer.presentation.screen.item.ItemDetailScreen
import com.example.shoporganizer.presentation.screen.home.HomeScreen
import com.example.shoporganizer.presentation.screen.profile.ProfileScreen
import com.example.shoporganizer.navigation.screen.BottomNavItemScreen
import com.example.shoporganizer.navigation.screen.Screen
import com.example.shoporganizer.utils.Constants.ITEM_ARGUMENT_KEY

@Composable
fun MainNavGraph(navController: NavHostController) {
    val actions = remember(navController) { AppActions(navController) }

    NavHost(
        navController = navController,
        route = Graph.MAIN,
        startDestination = BottomNavItemScreen.Home.route
    ) {
        composable(route = BottomNavItemScreen.Home.route) {
            HomeScreen(navController = navController)
        }

        composable(route = BottomNavItemScreen.Profile.route) {
            ProfileScreen()
        }

        detailsNavGraph(actions = actions)
    }
}

fun NavGraphBuilder.detailsNavGraph(actions: AppActions) {
    navigation(
        route = Graph.DETAILS,
        startDestination = Screen.Details.route
    ) {
        composable(
            route = Screen.Details.route,
            arguments = listOf(navArgument(ITEM_ARGUMENT_KEY) {
                type = NavType.IntType
            })
        ) {
            ItemDetailScreen(navigateUp = actions.navigateUp)
        }
    }
}

class AppActions(navController: NavHostController) {
    val navigateUp: () -> Unit = { navController.navigateUp() }
}
