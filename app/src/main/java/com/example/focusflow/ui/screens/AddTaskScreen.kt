package com.example.focusflow.ui.screens
package com.focusflow.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.focusflow.data.database.entities.StudyTaskEntity
import com.focusflow.ui.viewmodels.TaskViewModel
import com.focusflow.utils.DateUtils
import com.focusflow.utils.toast
import kotlinx.coroutines.launch

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
    ) { padding ->
        Column(
            modifier = Modifier.fillMaxSize().padding(padding).padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(8.dp)
            {
                OutlinedTextField(value = title, onValueChange = { title = it }, label = { Text("Title") }, modifier = Modifier.fillMaxWidth())
                OutlinedTextField(value = subject, onValueChange = { subject = it }, label = { Text("Subject") }, modifier = Modifier.fillMaxWidth())
                OutlinedTextField(value = deadline, onValueChange = { deadline = it }, label = { Text("Deadline (dd/MM/yyyy)") }, modifier = Modifier.fillMaxWidth())
                DropdownMenuBox(
                    selected = priority,
                    options = listOf("High", "Medium", "Low"),
                    onSelection = { priority = it }
                )
                OutlinedTextField(value = notes, onValueChange = { notes = it }, label = { Text("Notes") }, modifier = Modifier.fillMaxWidth())
                Button(onClick = {
                    if (title.isBlank() || subject.isBlank() || deadline.isBlank()) {
                        context.toast("Please fill all fields")
                        return@Button
                    }
                    val timestamp = DateUtils.parseDateToTimestamp(deadline)
                    if (timestamp == -1L) {
                        context.toast("Invalid date")
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
                }) {
                    Text("Save")
                }
            }
    }
}

@Composable
fun DropdownMenuBox(selected: String, options: List<String>, onSelection: (String) -> Unit) {
    var expanded by remember { mutableStateOf(false) }
    Box {
        OutlinedTextField(value = selected, onValueChange = {}, label = { Text("Priority") }, readOnly = true, modifier = Modifier.fillMaxWidth().clickable { expanded = true })
        DropdownMenu(expanded = expanded, onDismissRequest = { expanded = false }) {
            options.forEach { option ->
                DropdownMenuItem(text = { Text(option) }, onClick = { onSelection(option); expanded = false })
            }
        }
    }
}