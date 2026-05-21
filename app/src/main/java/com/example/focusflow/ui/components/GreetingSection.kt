package com.example.focusflow.ui.components

//class GreetingSection {
//}

//package com.focusflow.ui.components

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import com.example.focusflow.utils.DateUtils
import java.util.Calendar

@Composable
fun GreetingSection() {
    val hour = Calendar.getInstance().get(Calendar.HOUR_OF_DAY)
    val greeting = when (hour) {
        in 0..11 -> "Good Morning"
        in 12..16 -> "Good Afternoon"
        else -> "Good Evening"
    }
    Column {
        Text(text = "$greeting, User", style = MaterialTheme.typography.headlineSmall)
        Text(text = DateUtils.getCurrentDate(), style = MaterialTheme.typography.bodyMedium)
    }
}