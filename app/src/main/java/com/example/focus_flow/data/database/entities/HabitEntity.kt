package com.example.focus_flow.data.database.entities

//class HabitEntity {
//}

//package com.focusflow.data.database.entities

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "habits")
data class HabitEntity(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    val habitName: String,
    val frequency: String,
    val reminderTime: Long,
    val iconRes: Int,
    val streak: Int = 0,
    val completedToday: Boolean = false,
    val lastCompletedDate: Long = 0L
)