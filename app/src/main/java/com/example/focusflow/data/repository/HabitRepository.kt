package com.example.focusflow.data.repository

//class HabitRepository {
//}

//package com.focusflow.data.repository

import com.example.focusflow.data.database.dao.HabitDao
import com.example.focusflow.data.database.entities.HabitEntity
import kotlinx.coroutines.flow.Flow

class HabitRepository(private val habitDao: HabitDao) {

    fun getAllHabits(): Flow<List<HabitEntity>> = habitDao.getAllHabits()
    suspend fun insertHabit(habit: HabitEntity) = habitDao.insertHabit(habit)
    suspend fun updateHabit(habit: HabitEntity) = habitDao.updateHabit(habit)
    suspend fun deleteHabit(habit: HabitEntity) = habitDao.deleteHabit(habit)
    fun getTotalStreak(): Flow<Int> = habitDao.getTotalStreak()
}