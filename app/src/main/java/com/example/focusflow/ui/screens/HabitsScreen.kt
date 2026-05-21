package com.example.focusflow.ui.screens

//class HabitsScreen {
//}

//package com.focusflow.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.example.focusflow.ui.components.BottomNavigationBar
import com.example.focusflow.ui.components.HabitItem
import com.example.focusflow.ui.navigation.Screen
import com.example.focusflow.ui.viewmodels.HabitViewModel
import com.example.focusflow.utils.DateUtils

@Composable
fun HabitsScreen(navController: NavController) {
    val habitViewModel: HabitViewModel = viewModel()
    val habits by habitViewModel.allHabits.observeAsState(emptyList())

    Scaffold(
        bottomBar = { BottomNavigationBar(navController) },
        floatingActionButton = {
            FloatingActionButton(onClick = { navController.navigate(Screen.AddHabit.route) }) {
                Text("+")
            }
        }
    ) { paddingValues ->
        LazyColumn(
            modifier = Modifier.fillMaxSize().padding(paddingValues),
            contentPadding = PaddingValues(16.dp),
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            items(habits) { habit ->
                HabitItem(
                    habit = habit,
                    onCheckedChange = { isChecked ->
                        val updated = habit.copy(completedToday = isChecked)
                        if (isChecked && habit.lastCompletedDate != DateUtils.getTodayTimestamp()) {
                            // Increase streak
                            habitViewModel.updateHabit(
                                updated.copy(
                                    streak = habit.streak + 1,
                                    lastCompletedDate = DateUtils.getTodayTimestamp()
                                )
                            )
                        } else {
                            habitViewModel.updateHabit(updated)
                        }
                    }
                )
            }
        }
    }
}