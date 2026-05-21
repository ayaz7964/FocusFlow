package com.example.focusflow.ui.components

//class ProductivityScoreCard {
//}

//package com.focusflow.ui.components

import androidx.compose.foundation.layout.*
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun ProductivityScoreCard(score: Int) {
    Card(modifier = Modifier.fillMaxWidth()) {
        Row(
            modifier = Modifier.padding(16.dp),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text(text = "Productivity Score", style = MaterialTheme.typography.bodyLarge)
            Text(text = "$score%", style = MaterialTheme.typography.headlineSmall, color = MaterialTheme.colorScheme.secondary)
        }
    }
}