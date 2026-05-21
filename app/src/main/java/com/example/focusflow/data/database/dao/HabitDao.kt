package com.example.focusflow.data.database.dao

//class HabitDao {
//}


//package com.focusflow.data.database.dao

import androidx.room.*
import com.example.focusflow.data.database.entities.HabitEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface HabitDao {
    @Query("SELECT * FROM habits")
    fun getAllHabits(): Flow<List<HabitEntity>>

    @Insert
    suspend fun insertHabit(habit: HabitEntity)

    @Update
    suspend fun updateHabit(habit: HabitEntity)

    @Delete
    suspend fun deleteHabit(habit: HabitEntity)

    @Query("SELECT SUM(streak) FROM habits")
    fun getTotalStreak(): Flow<Int>
}