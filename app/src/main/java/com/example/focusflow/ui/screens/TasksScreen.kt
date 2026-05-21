package com.example.focusflow.ui.screens

//class TasksScreen {
//}
//package com.focusflow.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.focusflow.ui.components.BottomNavigationBar
import com.focusflow.ui.components.TaskItem
import com.focusflow.ui.navigation.Screen
import com.focusflow.ui.viewmodels.TaskViewModel

@Composable
fun TasksScreen(navController: NavController) {
    val taskViewModel: TaskViewModel = viewModel()
    val tasks by taskViewModel.allTasks.observeAsState(emptyList())

    Scaffold(
        bottomBar = { BottomNavigationBar(navController) },
        floatingActionButton = {
            FloatingActionButton(onClick = { navController.navigate(Screen.AddTask.route) }) {
                Text("+")
            }
        }
    ) { padding ->
        LazyColumn(
            modifier = Modifier.fillMaxSize().padding(padding),
            contentPadding = PaddingValues(16.dp),
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            items(tasks) { task ->
                TaskItem(task = task) {
                    navController.navigate(Screen.TaskDetail.passId(task.id))
                }
            }
        }
    }
}