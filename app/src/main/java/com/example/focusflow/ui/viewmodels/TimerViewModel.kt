package com.example.focusflow.ui.viewmodels

//class TimerViewModel {
//}

//package com.focusflow.ui.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.focusflow.data.database.entities.FocusSessionEntity
import com.focusflow.data.repository.FocusRepository
import kotlinx.coroutines.launch

class TimerViewModel(private val repository: FocusRepository) : ViewModel() {

    fun saveSession(duration: Int, category: String, timestamp: Long) {
        viewModelScope.launch {
            val session = FocusSessionEntity(
                duration = duration,
                category = category,
                date = timestamp
            )
            repository.insertSession(session)
        }
    }
}