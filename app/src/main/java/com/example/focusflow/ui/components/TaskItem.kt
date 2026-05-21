package com.example.focusflow.ui.components

//class TaskItem {
//}
//package com.focusflow.ui.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.focusflow.data.database.entities.StudyTaskEntity
import com.focusflow.utils.DateUtils

@Composable
fun TaskItem(task: StudyTaskEntity, onClick: () -> Unit) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 4.dp)
            .clickable { onClick() },
        elevation = CardDefaults.cardElevation(2.dp)
    ) {
        Column(modifier = Modifier.padding(16.dp)) {
            Text(text = task.title, style = MaterialTheme.typography.titleMedium)
            Text(text = task.subject, style = MaterialTheme.typography.bodySmall)
            Text(text = "Deadline: ${DateUtils.formatDate(task.deadline)}", style = MaterialTheme.typography.bodySmall)
        }
    }
}