package com.example.focus_flow.data.database.entities

//class StudyTaskEntity {
//}


//package com.focusflow.data.database.entities

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "study_tasks")
data class StudyTaskEntity(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    val title: String,
    val subject: String,
    val deadline: Long,
    val priority: String,
    val notes: String,
    val status: String
)