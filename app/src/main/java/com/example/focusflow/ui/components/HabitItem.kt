package com.example.focusflow.ui.components

//class HabitItem {
//}

//package com.focusflow.ui.components

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.focusflow.data.database.entities.HabitEntity

@Composable
fun HabitItem(habit: HabitEntity, onCheckedChange: (Boolean) -> Unit) {
    Card(modifier = Modifier.fillMaxWidth().padding(vertical = 4.dp)) {
        Row(
            modifier = Modifier.padding(16.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Checkbox(checked = habit.completedToday, onCheckedChange = onCheckedChange)
            Spacer(modifier = Modifier.width(8.dp))
            Column {
                Text(text = habit.habitName, style = MaterialTheme.typography.bodyLarge)
                Text(text = "${habit.streak} day streak", style = MaterialTheme.typography.bodySmall)
            }
        }
    }
}