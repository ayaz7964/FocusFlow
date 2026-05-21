package com.example.focusflow.ui.screens

//class AnalyticsScreen {
//}

//package com.focusflow.ui.screens

import android.graphics.Color
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.viewinterop.AndroidView
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.example.focusflow.ui.components.BottomNavigationBar
import com.example.focusflow.ui.viewmodels.AnalyticsViewModel
import com.example.focusflow.ui.viewmodels.HabitViewModel
import com.github.mikephil.charting.charts.BarChart
import com.github.mikephil.charting.data.BarData
import com.github.mikephil.charting.data.BarDataSet
import com.github.mikephil.charting.data.BarEntry
import com.github.mikephil.charting.formatter.IndexAxisValueFormatter
import java.text.SimpleDateFormat
import java.util.*

@Composable
fun AnalyticsScreen(navController: NavController) {
    val analyticsViewModel: AnalyticsViewModel = viewModel()
    val habitViewModel: HabitViewModel = viewModel()
    val weeklyFocus by analyticsViewModel.getWeeklyFocus().observeAsState(emptyList())
    val totalStreak by habitViewModel.totalStreak.observeAsState(0)
    var completedTasks by remember { mutableStateOf(0) }
    LaunchedEffect(Unit) {
        completedTasks = analyticsViewModel.getCompletedTasksCount()
    }

    Scaffold(bottomBar = { BottomNavigationBar(navController) }) { paddingValues ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
                .padding(16.dp)
        ) {
            Text("Analytics", style = MaterialTheme.typography.headlineMedium)
            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 8.dp)
            ) {
                Column(modifier = Modifier.padding(16.dp)) {
                    Text("✅ Completed Tasks: $completedTasks")
                    Text("🔥 Total Habit Streak: $totalStreak days")
                }
            }
            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(300.dp)
            ) {
                AndroidView(
                    factory = { context ->
                        BarChart(context).apply {
                            val entries = weeklyFocus.mapIndexed { i, day ->
                                BarEntry(i.toFloat(), day.total.toFloat())
                            }
                            val dataSet = BarDataSet(entries, "Focus Minutes").apply {
                                color = Color.parseColor("#8B5CF6")
                            }
                            this.data = BarData(dataSet)
                            description.isEnabled = false
                            xAxis.valueFormatter = IndexAxisValueFormatter(
                                weeklyFocus.map {
                                    SimpleDateFormat("EEE", Locale.getDefault()).format(Date(it.date))
                                }
                            )
                            invalidate()
                        }
                    }
                )
            }
        }
    }
}