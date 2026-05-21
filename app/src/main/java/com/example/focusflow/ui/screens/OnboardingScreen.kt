package com.example.focusflow.ui.screens

//class OnboardingScreen {
//}

//package com.focusflow.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.focusflow.data.preferences.PrefManager
import com.focusflow.ui.navigation.Screen
import com.google.accompanist.pager.*

@OptIn(ExperimentalPagerApi::class)
@Composable
fun OnboardingScreen(navController: NavController) {
    val prefManager = remember { PrefManager(navController.context.applicationContext) }
    val pages = listOf(
        "Plan Your Studies" to "Create tasks with deadlines and priorities.",
        "Track Habits" to "Build daily routines and maintain streaks.",
        "Stay Focused" to "Use Pomodoro timer to boost productivity."
    )
    val pagerState = rememberPagerState()

    Scaffold(
        bottomBar = {
            Row(
                modifier = Modifier.fillMaxWidth().padding(16.dp),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                TextButton(onClick = {
                    prefManager.setOnboardingCompleted()
                    navController.navigate(Screen.Home.route) {
                        popUpTo(Screen.Onboarding.route) { inclusive = true }
                    }
                }) { Text("Skip") }
                Button(onClick = {
                    if (pagerState.currentPage < pages.size - 1) {
                        pagerState.animateScrollToPage(pagerState.currentPage + 1)
                    } else {
                        prefManager.setOnboardingCompleted()
                        navController.navigate(Screen.Home.route) {
                            popUpTo(Screen.Onboarding.route) { inclusive = true }
                        }
                    }
                }) { Text(if (pagerState.currentPage == pages.size - 1) "Get Started" else "Next") }
            }
        }
    ) { padding ->
        HorizontalPager(
            count = pages.size,
            state = pagerState,
            modifier = Modifier.fillMaxSize().padding(padding)
        ) { page ->
            Column(
                modifier = Modifier.fillMaxSize(),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {
                Text(pages[page].first, style = MaterialTheme.typography.headlineMedium)
                Spacer(modifier = Modifier.height(16.dp))
                Text(pages[page].second, style = MaterialTheme.typography.bodyLarge)
            }
        }
    }
}