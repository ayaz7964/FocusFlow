package com.example.focus_flow.data.database.entities

//class FocusSessionEntity {
//}

//package com.focusflow.data.database.entities

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "focus_sessions")
data class FocusSessionEntity(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    val duration: Int,
    val category: String,
    val date: Long
)