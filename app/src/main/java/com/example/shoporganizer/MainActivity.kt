package com.example.shoporganizer

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.example.shoporganizer.ui.theme.ShopOrganizerTheme
import com.example.shoporganizer.navigation.AppNavigation
class MainActivity : ComponentActivity() {
    @SuppressLint("UnusedMaterialScaffoldPaddingParameter")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ShopOrganizerTheme {
                /******************************************************
                 * Implemented another navigation to handle navigating
                 * to selected shop items. This is a work in progress
                 * and I will revisit the bottom nav soon.
                 *****************************************************/
                AppNavigation()
            }
        }
    }
}







