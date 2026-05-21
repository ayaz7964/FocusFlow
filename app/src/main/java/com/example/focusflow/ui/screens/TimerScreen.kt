package com.example.focusflow.ui.screens

//class TimerScreen {
//}

//package com.focusflow.ui.screens

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.example.focusflow.ui.viewmodels.TimerViewModel
import com.example.focusflow.utils.toast
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

@Composable
fun TimerScreen(navController: NavController) {
    val timerViewModel: TimerViewModel = viewModel()
    val context = LocalContext.current
    val scope = rememberCoroutineScope()

    var timeLeft by remember { mutableStateOf(25 * 60L) }
    var isFocus by remember { mutableStateOf(true) }
    var isRunning by remember { mutableStateOf(false) }
    var category by remember { mutableStateOf("Study") }
    var job by remember { mutableStateOf<kotlinx.coroutines.Job?>(null) }

    fun startTimer() {
        if (isRunning) return
        isRunning = true
        job = scope.launch {
            while (timeLeft > 0 && isRunning) {
                delay(1000L)
                timeLeft--
            }
            if (timeLeft == 0L) {
                if (isFocus) {
                    timerViewModel.saveSession(25, category, System.currentTimeMillis())
                    context.toast("Focus session completed! Take a break.")
                    isFocus = false
                    timeLeft = 5 * 60L
                    startTimer()
                } else {
                    context.toast("Break over! Ready to focus again?")
                    resetTimer()
                }
            }
        }
    }

    fun pauseTimer() {
        isRunning = false
        job?.cancel()
    }

    fun resetTimer() {
        pauseTimer()
        isFocus = true
        timeLeft = 25 * 60L
        isRunning = false
    }

    DisposableEffect(Unit) {
        onDispose { job?.cancel() }
    }

    Column(
        modifier = Modifier.fillMaxSize().padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(
            text = "${timeLeft / 60}:${String.format("%02d", timeLeft % 60)}",
            style = MaterialTheme.typography.displayLarge
        )
        Spacer(modifier = Modifier.height(16.dp))
        LinearProgressIndicator(
            progress = if (isFocus) (25 * 60 - timeLeft) / (25 * 60f) else (5 * 60 - timeLeft) / (5 * 60f),
            modifier = Modifier.fillMaxWidth()
        )
        Spacer(modifier = Modifier.height(16.dp))
        Row(horizontalArrangement = Arrangement.spacedBy(8.dp)) {
            Button(onClick = { if (!isRunning) startTimer() }) { Text("Start") }
            Button(onClick = { pauseTimer() }) { Text("Pause") }
            Button(onClick = { resetTimer() }) { Text("Reset") }
        }
        Spacer(modifier = Modifier.height(16.dp))
        // Category dropdown
        var expanded by remember { mutableStateOf(false) }
        Box(modifier = Modifier.fillMaxWidth()) {
            OutlinedTextField(
                value = category,
                onValueChange = {},
                label = { Text("Category") },
                readOnly = true,
                modifier = Modifier
                    .fillMaxWidth()
                    .clickable { expanded = true }
            )
            DropdownMenu(
                expanded = expanded,
                onDismissRequest = { expanded = false }
            ) {
                listOf("Study", "Coding", "Reading", "Custom").forEach { option ->
                    DropdownMenuItem(
                        text = { Text(option) },
                        onClick = {
                            category = option
                            expanded = false
                        }
                    )
                }
            }
        }
    }
}