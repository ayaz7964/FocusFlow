package com.example.focusflow.ui.screens

//class SplashScreen {
//}

//package com.focusflow.ui.screens

import androidx.compose.animation.core.*
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.focusflow.R
import com.focusflow.data.preferences.PrefManager
import com.focusflow.ui.navigation.Screen
import kotlinx.coroutines.delay

@Composable
fun SplashScreen(navController: NavController) {
    val prefManager = remember { PrefManager(navController.context.applicationContext) }
    val alpha = animateFloatAsState(
        targetValue = 1f,
        animationSpec = tween(1000),
        label = "alpha"
    )

    LaunchedEffect(Unit) {
        delay(2000)
        val route = if (!prefManager.isOnboardingCompleted()) Screen.Onboarding.route else Screen.Home.route
        navController.navigate(route) {
            popUpTo(Screen.Splash.route) { inclusive = true }
        }
    }

    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Column(horizontalAlignment = Alignment.CenterHorizontally) {
            Image(
                painter = painterResource(id = R.drawable.ic_logo),
                contentDescription = "Logo",
                modifier = Modifier.size(120.dp).alpha(alpha.value)
            )
            Text(text = "FocusFlow", style = MaterialTheme.typography.headlineLarge, modifier = Modifier.alpha(alpha.value))
        }
    }
}