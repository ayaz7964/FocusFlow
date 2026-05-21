package com.example.focusflow.ui.screens

//class ProfileScreen {
//}

//package com.focusflow.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.focusflow.ui.components.BottomNavigationBar

@Composable
fun ProfileScreen(navController: NavController) {
    Scaffold(bottomBar = { BottomNavigationBar(navController) }) { paddingValues ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
                .padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            Text("Profile", style = MaterialTheme.typography.headlineMedium)
            Card(modifier = Modifier.fillMaxWidth()) {
                Column(modifier = Modifier.padding(16.dp)) {
                    Text("FocusFlow v1.0", style = MaterialTheme.typography.titleLarge)
                    Spacer(modifier = Modifier.height(8.dp))
                    Text("A smart study planner & daily habit tracker.")
                    Text("Designed with MVVM, Room, WorkManager and Compose.")
                    Text("All data stored offline.")
                    Spacer(modifier = Modifier.height(8.dp))
                    Text("© 2025 FocusFlow - Semester Project")
                }
            }
        }
    }
}