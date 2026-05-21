package com.focusflow.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.clickable
import androidx.compose.material3.*
import androidx.compose.runtime.*
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
fun AddTaskScreen(navController: NavController) {
    val taskViewModel: TaskViewModel = viewModel()
    val context = LocalContext.current
    val scope = rememberCoroutineScope()

    var title by remember { mutableStateOf("") }
    var subject by remember { mutableStateOf("") }
    var deadline by remember { mutableStateOf("") }
    var priority by remember { mutableStateOf("Medium") }
    var notes by remember { mutableStateOf("") }

    Scaffold(
        topBar = { TopAppBar(title = { Text("Add Task") }) }
    ) { paddingValues ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
                .padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            OutlinedTextField(
                value = title,
                onValueChange = { title = it },
                label = { Text("Title") },
                modifier = Modifier.fillMaxWidth()
            )
            OutlinedTextField(
                value = subject,
                onValueChange = { subject = it },
                label = { Text("Subject") },
                modifier = Modifier.fillMaxWidth()
            )
            OutlinedTextField(
                value = deadline,
                onValueChange = { deadline = it },
                label = { Text("Deadline (dd/MM/yyyy)") },
                modifier = Modifier.fillMaxWidth()
            )
            // Priority dropdown
            var expanded by remember { mutableStateOf(false) }
            Box(modifier = Modifier.fillMaxWidth()) {
                OutlinedTextField(
                    value = priority,
                    onValueChange = {},
                    label = { Text("Priority") },
                    readOnly = true,
                    modifier = Modifier
                        .fillMaxWidth()
                        .clickable { expanded = true }
                )
                DropdownMenu(
                    expanded = expanded,
                    onDismissRequest = { expanded = false },
                    modifier = Modifier.fillMaxWidth()
                ) {
                    listOf("High", "Medium", "Low").forEach { option ->
                        DropdownMenuItem(
                            text = { Text(option) },
                            onClick = {
                                priority = option
                                expanded = false
                            }
                        )
                    }
                }
            }
            OutlinedTextField(
                value = notes,
                onValueChange = { notes = it },
                label = { Text("Notes") },
                modifier = Modifier.fillMaxWidth()
            )
            Button(
                onClick = {
                    if (title.isBlank() || subject.isBlank() || deadline.isBlank()) {
                        context.toast("Please fill all fields")
                        return@Button
                    }
                    val timestamp = DateUtils.parseDateToTimestamp(deadline)
                    if (timestamp == -1L) {
                        context.toast("Invalid date. Use dd/MM/yyyy")
                        return@Button
                    }
                    val task = StudyTaskEntity(
                        title = title,
                        subject = subject,
                        deadline = timestamp,
                        priority = priority,
                        notes = notes,
                        status = "PENDING"
                    )
                    scope.launch {
                        taskViewModel.insertTask(task)
                        context.toast("Task added")
                        navController.navigateUp()
                    }
                },
                modifier = Modifier.fillMaxWidth()
            ) {
                Text("Save")
            }
        }
    }
}