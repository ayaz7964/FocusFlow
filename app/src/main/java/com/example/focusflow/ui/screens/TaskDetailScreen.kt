package com.example.focusflow.ui.screens

//class TaskDetailScreen {
//}

//package com.focusflow.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.example.focusflow.data.database.entities.StudyTaskEntity
import com.example.focusflow.ui.viewmodels.TaskViewModel
import com.example.focusflow.utils.DateUtils
import com.example.focusflow.utils.toast
import kotlinx.coroutines.launch

@ExperimentalMaterial3Api
@Composable
fun TaskDetailScreen(navController: NavController, taskId: Int) {
    val taskViewModel: TaskViewModel = viewModel()
    val context = LocalContext.current
    val scope = rememberCoroutineScope()
    var task by remember { mutableStateOf<StudyTaskEntity?>(null) }
    var isLoading by remember { mutableStateOf(true) }

    LaunchedEffect(taskId) {
        task = taskViewModel.getTaskById(taskId)
        isLoading = false
    }

    Scaffold(
        topBar = { TopAppBar(title = { Text("Task Details") }) }
    ) { paddingValues ->
        if (isLoading) {
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(paddingValues),
                contentAlignment = Alignment.Center
            ) {
                CircularProgressIndicator()
            }
        } else if (task == null) {
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(paddingValues),
                contentAlignment = Alignment.Center
            ) {
                Text("Task not found")
            }
        } else {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(paddingValues)
                    .padding(16.dp),
                verticalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                Text(text = task!!.title, style = MaterialTheme.typography.headlineSmall)
                Text("Subject: ${task!!.subject}")
                Text("Deadline: ${DateUtils.formatDate(task!!.deadline)}")
                Text("Priority: ${task!!.priority}")
                Text("Status: ${task!!.status}")
                Text("Notes: ${task!!.notes}")
                Spacer(modifier = Modifier.height(16.dp))
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.spacedBy(8.dp)
                ) {
                    Button(
                        onClick = {
                            scope.launch {
                                taskViewModel.updateTask(task!!.copy(status = "COMPLETED"))
                                context.toast("Task marked completed")
                                navController.navigateUp()
                            }
                        },
                        modifier = Modifier.weight(1f)
                    ) {
                        Text("Complete")
                    }
                    Button(
                        onClick = {
                            scope.launch {
                                taskViewModel.deleteTask(task!!)
                                context.toast("Task deleted")
                                navController.navigateUp()
                            }
                        },
                        modifier = Modifier.weight(1f),
                        colors = ButtonDefaults.buttonColors(containerColor = MaterialTheme.colorScheme.error)
                    ) {
                        Text("Delete")
                    }
                }
            }
        }
    }
}