package com.example.shoporganizer.navigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.shoporganizer.home.HomeScreen
import com.example.shoporganizer.item.ItemDetailScreen
import com.example.shoporganizer.navigation.AppDestinations.ITEM_DETAIL_ID_KEY
import com.example.shoporganizer.profile.ProfileScreen

private object AppDestinations {
    const val HOME_ROUTE = "home_screen"
    const val PROFILE_ROUTE = "profile_screen"
    const val ITEM_DETAIL_ROUTE = "item_detail_screen"
    const val ITEM_DETAIL_ID_KEY = "itemId"
}

@Composable
fun AppNavigation(
    startDestination: String = AppDestinations.HOME_ROUTE
) {
    val navController = rememberNavController()
    val actions = remember(navController) { AppActions(navController) }

    NavHost(
        navController = navController,
        startDestination = startDestination
    ) {
        composable(
            AppDestinations.HOME_ROUTE
        ) {
            HomeScreen(selectedItem = actions.selectedItem)
        }
        composable(
            "${AppDestinations.ITEM_DETAIL_ROUTE}/{$ITEM_DETAIL_ID_KEY}",
            arguments = listOf(
                navArgument(ITEM_DETAIL_ID_KEY) {
                    type = NavType.IntType
                }
            )
        ) { backStackEntry ->
            val arguments = requireNotNull(backStackEntry.arguments)
            ItemDetailScreen(
                itemId = arguments.getInt(ITEM_DETAIL_ID_KEY),
                navigateUp = actions.navigateUp
            )
        }
        composable(AppDestinations.PROFILE_ROUTE){
            ProfileScreen()
        }
    }
}

private class AppActions(
    navController: NavHostController
) {
    val selectedItem: (Int) -> Unit = { itemId: Int ->
        navController.navigate("${AppDestinations.ITEM_DETAIL_ROUTE}/$itemId")
    }
    val navigateUp: () -> Unit = {
        navController.navigateUp()
    }
}
