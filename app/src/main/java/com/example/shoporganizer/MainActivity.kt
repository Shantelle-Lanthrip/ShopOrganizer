package com.example.shoporganizer

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.padding
import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.ContentAlpha
import androidx.compose.material.LocalContentColor
import androidx.compose.material.icons.Icons
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.shoporganizer.ui.theme.ShopOrganizerTheme
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.Home
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Icon
import androidx.compose.runtime.getValue
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.NavDestination
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHost
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.shoporganizer.bottomnavigation.BottomBarScreen
import com.example.shoporganizer.bottomnavigation.BottomNavGraph
import com.example.shoporganizer.home.HomeScreen
import com.example.shoporganizer.profile.ProfileScreen


class MainActivity : ComponentActivity() {
    @SuppressLint("UnusedMaterialScaffoldPaddingParameter")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ShopOrganizerTheme {
                val navHostController = rememberNavController()
                androidx.compose.material.Scaffold(
                    bottomBar = { BottomNav(navController = navHostController) }
                ) {
                    BottomNavGraph(navHostController)
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    ShopOrganizerTheme {
        Greeting("Android")
    }
}



//@Composable
//private fun BottomNav(modifier: Modifier = Modifier, navController: NavController) {
//    NavigationBar(
//        modifier = modifier
//    ) {
//        NavigationBarItem(
//            icon = {
//                Icon(
//                    imageVector = Icons.Default.Home,
//                    contentDescription = null
//                )
//            },
//            label = {
//                Text(
//                    text = stringResource(R.string.bottom_nav_home)
//                )
//            },
//            selected = true,
//            onClick = {
//                navController.navigate("home_screen"){
//            }
//    }
//        )
//        NavigationBarItem(
//            icon = {
//                Icon(
//                    imageVector = Icons.Default.AccountCircle,
//                    contentDescription = null
//                )
//            },
//            label = {
//                Text(
//                    text = stringResource(R.string.bottom_nav_profile)
//                )
//            },
//            selected = currentDestination?.hierarchy?.any{
//                it.route == screen.route
//            } == true,
//
//
//
//            onClick = {
//                navController.navigate("profile_screen"){
//
//
//                }
//            }
//
//        )
//    }
//}


@Composable
fun BottomNav(navController: NavHostController){
    val screens = listOf(
        BottomBarScreen.Home,
        BottomBarScreen.Profile
    )
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentDestination = navBackStackEntry?.destination

    NavigationBar {
        screens.forEach { screen->
            AddItem(
                screen = screen,
                currentDestination = currentDestination,
                navController = navController)
        }
    }
}

@Composable
fun RowScope.AddItem(
    screen: BottomBarScreen,
    currentDestination: NavDestination?,
    navController: NavHostController
) {
    NavigationBarItem(
        label = {
            Text(text = screen.title)
        },
        icon = {
            androidx.compose.material.Icon(
                imageVector = screen.icon,
                contentDescription = "Navigation Icon"
            )
        },
        selected = currentDestination?.hierarchy?.any{
            it.route == screen.route
        } == true,
        //unselectedContentColor = LocalContentColor.current.copy(alpha = ContentAlpha.disabled),
        onClick = {
            navController.navigate(screen.route){
                popUpTo(navController.graph.findStartDestination().id)
                launchSingleTop = true
            }
        }
    )
}

