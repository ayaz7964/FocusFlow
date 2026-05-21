package com.example.focusflow.ui.components

//class QuickActionsRow {
//}

//package com.focusflow.ui.components

import androidx.compose.foundation.layout.*
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun QuickActionsRow(
    onAddTask: () -> Unit,
    onAddHabit: () -> Unit,
    onStartFocus: () -> Unit
) {
    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        Button(onClick = onAddTask, modifier = Modifier.weight(1f)) {
            Text("Add Task")
        }
        Button(onClick = onAddHabit, modifier = Modifier.weight(1f)) {
            Text("Add Habit")
        }
        Button(onClick = onStartFocus, modifier = Modifier.weight(1f)) {
            Text("Focus")
        }
    }
}