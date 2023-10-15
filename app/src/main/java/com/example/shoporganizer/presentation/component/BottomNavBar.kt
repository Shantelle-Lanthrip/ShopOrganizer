package com.example.shoporganizer.presentation.component

import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.navigation.NavController
import androidx.navigation.compose.currentBackStackEntryAsState
import com.example.shoporganizer.navigation.screen.BottomNavItemScreen

@Composable
fun BottomNavBar(
    modifier: Modifier = Modifier,
    navController: NavController,
) {
    val navigationItems = listOf(
        BottomNavItemScreen.Home,
        BottomNavItemScreen.Profile
    )

    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentRoute = navBackStackEntry?.destination?.route
    val bottomBarDestination = navigationItems.any { it.route == currentRoute }

    if (bottomBarDestination) {
        NavigationBar() {
            navigationItems.forEach { item ->
                NavigationBarItem(
                    label = {
                        Text(
                            text = stringResource(id = item.title),
                        )
                    },
                    icon = {
                        Icon(
                            imageVector = item.icon,
                            contentDescription = stringResource(id = item.title))
                    },
                    selected = currentRoute == item.route,
                    onClick = {
                        navController.navigate(item.route) {
                            navController.graph.startDestinationRoute?.let { screen_route ->
                                popUpTo(screen_route) { saveState = true }
                            }
                            launchSingleTop = true
                            restoreState = true
                        }
                    }
                )
            }
        }
    }
}
