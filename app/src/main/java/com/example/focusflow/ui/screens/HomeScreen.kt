package com.example.focusflow.ui.screens

//class HomeScreen {
//}

//package com.focusflow.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.focusflow.ui.components.*
import com.focusflow.ui.navigation.Screen
import com.focusflow.ui.viewmodels.HabitViewModel
import com.focusflow.ui.viewmodels.TaskViewModel

@Composable
fun HomeScreen(navController: NavController) {
    val taskViewModel: TaskViewModel = viewModel()
    val habitViewModel: HabitViewModel = viewModel()
    val tasks by taskViewModel.pendingTasks.observeAsState(emptyList())
    val habits by habitViewModel.allHabits.observeAsState(emptyList())
    var completedCount by remember { mutableStateOf(0) }
    val scope = rememberCoroutineScope()

    LaunchedEffect(Unit) {
        completedCount = taskViewModel.getCompletedCount()
    }

    Scaffold(
        bottomBar = { BottomNavigationBar(navController) }
    ) { padding ->
        LazyColumn(
            modifier = Modifier.fillMaxSize().padding(padding),
            contentPadding = PaddingValues(16.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            item { GreetingSection() }
            item { ProductivityScoreCard(score = completedCount * 10) }
            item {
                TodayTasksCard(tasks = tasks.take(3)) { taskId ->
                    navController.navigate(Screen.TaskDetail.passId(taskId))
                }
            }
            item {
                HabitsPreviewCard(habits = habits) { habit, isChecked ->
                    val updated = habit.copy(completedToday = isChecked)
                    if (isChecked) {
                        val newStreak = if (habit.lastCompletedDate != DateUtils.getTodayTimestamp())
                            habit.streak + 1 else habit.streak
                        habitViewModel.updateHabit(updated.copy(streak = newStreak, lastCompletedDate = DateUtils.getTodayTimestamp()))
                    } else {
                        habitViewModel.updateHabit(updated)
                    }
                }
            }
            item {
                QuickActionsRow(
                    onAddTask = { navController.navigate(Screen.AddTask.route) },
                    onAddHabit = { navController.navigate(Screen.AddHabit.route) },
                    onStartFocus = { navController.navigate(Screen.Timer.route) }
                )
            }
        }
    }
}