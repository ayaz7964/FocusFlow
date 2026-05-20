package com.example.focus_flow.data.database.dao

//class StudyTaskDao {
//}


//package com.focusflow.data.database.dao

import androidx.room.*
import com.focusflow.data.database.entities.StudyTaskEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface StudyTaskDao {
    @Query("SELECT * FROM study_tasks ORDER BY deadline ASC")
    fun getAllTasks(): Flow<List<StudyTaskEntity>>

    @Query("SELECT * FROM study_tasks WHERE status = 'PENDING' ORDER BY deadline ASC")
    fun getPendingTasks(): Flow<List<StudyTaskEntity>>

    @Query("SELECT * FROM study_tasks WHERE id = :taskId")
    suspend fun getTaskById(taskId: Int): StudyTaskEntity?

    @Insert
    suspend fun insertTask(task: StudyTaskEntity)

    @Update
    suspend fun updateTask(task: StudyTaskEntity)

    @Delete
    suspend fun deleteTask(task: StudyTaskEntity)

    @Query("SELECT COUNT(*) FROM study_tasks WHERE status = 'COMPLETED'")
    suspend fun getCompletedCount(): Int
}