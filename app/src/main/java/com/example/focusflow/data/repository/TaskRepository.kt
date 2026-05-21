package com.example.focusflow.data.repository

//class TaskRepository {
//}

//package com.focusflow.data.repository

import com.focusflow.data.database.dao.StudyTaskDao
import com.focusflow.data.database.entities.StudyTaskEntity
import kotlinx.coroutines.flow.Flow

class TaskRepository(private val taskDao: StudyTaskDao) {

    fun getAllTasks(): Flow<List<StudyTaskEntity>> = taskDao.getAllTasks()
    fun getPendingTasks(): Flow<List<StudyTaskEntity>> = taskDao.getPendingTasks()
    suspend fun getTaskById(id: Int): StudyTaskEntity? = taskDao.getTaskById(id)
    suspend fun insertTask(task: StudyTaskEntity) = taskDao.insertTask(task)
    suspend fun updateTask(task: StudyTaskEntity) = taskDao.updateTask(task)
    suspend fun deleteTask(task: StudyTaskEntity) = taskDao.deleteTask(task)
    suspend fun getCompletedCount(): Int = taskDao.getCompletedCount()
}