package com.example.focusflow.ui.viewmodels

//class HabitViewModel {
//}

//package com.focusflow.ui.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import androidx.lifecycle.viewModelScope
import com.focusflow.data.database.entities.HabitEntity
import com.focusflow.data.repository.HabitRepository
import kotlinx.coroutines.launch

class HabitViewModel(private val repository: HabitRepository) : ViewModel() {

    val allHabits: LiveData<List<HabitEntity>> = repository.getAllHabits().asLiveData()
    val totalStreak: LiveData<Int> = repository.getTotalStreak().asLiveData()

    fun insertHabit(habit: HabitEntity) = viewModelScope.launch {
        repository.insertHabit(habit)
    }

    fun updateHabit(habit: HabitEntity) = viewModelScope.launch {
        repository.updateHabit(habit)
    }

    fun deleteHabit(habit: HabitEntity) = viewModelScope.launch {
        repository.deleteHabit(habit)
    }
}