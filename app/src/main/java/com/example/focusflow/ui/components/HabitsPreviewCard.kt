package com.example.focusflow.ui.components

//class HabitsPreviewCard {
//}

//package com.focusflow.ui.components

import androidx.compose.foundation.layout.*
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.focusflow.data.database.entities.HabitEntity

@Composable
fun HabitsPreviewCard(habits: List<HabitEntity>, onHabitToggle: (HabitEntity, Boolean) -> Unit) {
    Card(modifier = Modifier.fillMaxWidth()) {
        Column(modifier = Modifier.padding(16.dp)) {
            Text(text = "Today's Habits", style = MaterialTheme.typography.titleMedium)
            Spacer(modifier = Modifier.height(8.dp))
            if (habits.isEmpty()) {
                Text(text = "No habits yet", style = MaterialTheme.typography.bodySmall)
            } else {
                habits.take(3).forEach { habit ->
                    HabitItem(habit = habit) { isChecked ->
                        onHabitToggle(habit, isChecked)
                    }
                }
            }
        }
    }
}