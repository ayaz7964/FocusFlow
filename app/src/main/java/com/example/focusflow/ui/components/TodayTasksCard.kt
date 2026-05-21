package com.example.focusflow.ui.components

//class TodayTasksCard {
//}

//package com.focusflow.ui.components

import androidx.compose.foundation.layout.*
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.focusflow.data.database.entities.StudyTaskEntity

@Composable
fun TodayTasksCard(tasks: List<StudyTaskEntity>, onTaskClick: (Int) -> Unit) {
    Card(modifier = Modifier.fillMaxWidth()) {
        Column(modifier = Modifier.padding(16.dp)) {
            Text(text = "Today's Tasks", style = MaterialTheme.typography.titleMedium)
            Spacer(modifier = Modifier.height(8.dp))
            if (tasks.isEmpty()) {
                Text(text = "No pending tasks", style = MaterialTheme.typography.bodySmall)
            } else {
                tasks.forEach { task ->
                    TaskItem(task = task) { onTaskClick(task.id) }
                }
            }
        }
    }
}