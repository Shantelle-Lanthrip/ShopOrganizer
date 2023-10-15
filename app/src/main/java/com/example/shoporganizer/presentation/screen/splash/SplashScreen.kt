package com.example.shoporganizer.presentation.screen.splash

import android.view.animation.OvershootInterpolator
import androidx.compose.animation.core.Animatable
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.shoporganizer.R
import com.example.shoporganizer.navigation.graph.Graph
import kotlinx.coroutines.delay

@Composable
fun SplashScreen(
    navController: NavHostController,
) {
    val scale = remember { Animatable(0f) }

    LaunchedEffect(key1 = true) {
        scale.animateTo(
            targetValue = 0.8f,
            animationSpec = tween(
                durationMillis = 200,
                easing = {
                    OvershootInterpolator(4f).getInterpolation(it)
                }
            )
        )
        delay(100)
        navController.popBackStack()

        navController.navigate(Graph.MAIN)
    }

    Splash(scale = scale.value)
}

@Composable
fun Splash(
    modifier: Modifier = Modifier,
    scale: Float
) {
    Box(
        modifier = modifier
            .background(Color.White)
            .fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Image(
            modifier = Modifier
                .size(100.dp)
                .scale(scale),
            contentScale = ContentScale.Crop,
            imageVector = Icons.Filled.Favorite,
            contentDescription = stringResource(R.string.app_name)
        )
    }
}