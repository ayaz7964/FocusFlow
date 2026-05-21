package com.example.focusflow.ui.viewmodels

//class AnalyticsViewModel {
//}

//package com.focusflow.ui.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import com.focusflow.data.database.dao.FocusSessionDao
import com.focusflow.data.repository.FocusRepository
import com.focusflow.data.repository.TaskRepository

class AnalyticsViewModel(
    private val taskRepository: TaskRepository,
    private val focusRepository: FocusRepository
) : ViewModel() {

    suspend fun getCompletedTasksCount(): Int = taskRepository.getCompletedCount()
    fun getWeeklyFocus(): LiveData<List<FocusSessionDao.DailyFocus>> = focusRepository.getWeeklyFocus().asLiveData()
}