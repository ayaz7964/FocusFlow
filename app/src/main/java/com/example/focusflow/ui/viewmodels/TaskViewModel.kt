package com.example.focusflow.ui.viewmodels

//class TaskViewModel {
//}

//package com.focusflow.ui.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import androidx.lifecycle.viewModelScope
import com.focusflow.data.database.entities.StudyTaskEntity
import com.focusflow.data.repository.TaskRepository
import kotlinx.coroutines.launch

class TaskViewModel(private val repository: TaskRepository) : ViewModel() {

    val allTasks: LiveData<List<StudyTaskEntity>> = repository.getAllTasks().asLiveData()
    val pendingTasks: LiveData<List<StudyTaskEntity>> = repository.getPendingTasks().asLiveData()

    fun insertTask(task: StudyTaskEntity) = viewModelScope.launch {
        repository.insertTask(task)
    }

    fun updateTask(task: StudyTaskEntity) = viewModelScope.launch {
        repository.updateTask(task)
    }

    fun deleteTask(task: StudyTaskEntity) = viewModelScope.launch {
        repository.deleteTask(task)
    }

    suspend fun getTaskById(id: Int): StudyTaskEntity? = repository.getTaskById(id)
    suspend fun getCompletedCount(): Int = repository.getCompletedCount()
}