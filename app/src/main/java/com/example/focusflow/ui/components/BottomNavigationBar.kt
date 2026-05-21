package com.example.focusflow.ui.components

//class BottomNavigationBar {
//}

//package com.focusflow.ui.components

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import androidx.navigation.compose.currentBackStackEntryAsState
import com.focusflow.ui.navigation.Screen

@Composable
fun BottomNavigationBar(navController: NavController) {
    val items = listOf(
        Screen.Home to "Home" to Icons.Default.Home,
        Screen.Tasks to "Tasks" to Icons.Default.List,
        Screen.Habits to "Habits" to Icons.Default.CheckCircle,
        Screen.Analytics to "Analytics" to Icons.Default.BarChart,
        Screen.Profile to "Profile" to Icons.Default.Person
    )
    NavigationBar {
        val currentRoute = navController.currentBackStackEntryAsState().value?.destination?.route
        items.forEach { (screenTitlePair, icon) ->
            val (screen, title) = screenTitlePair
            NavigationBarItem(
                selected = currentRoute == screen.route,
                onClick = { navController.navigate(screen.route) { launchSingleTop = true } },
                icon = { Icon(icon, contentDescription = title) },
                label = { Text(title) }
            )
        }
    }
}