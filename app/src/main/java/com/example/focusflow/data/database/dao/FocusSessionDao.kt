package com.example.focusflow.data.database.dao

//class FocusSessionDao {
//}

//package com.focusflow.data.database.dao

import androidx.room.*
import com.example.focusflow.data.database.entities.FocusSessionEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface FocusSessionDao {
    @Query("SELECT * FROM focus_sessions ORDER BY date DESC")
    fun getAllSessions(): Flow<List<FocusSessionEntity>>

    @Insert
    suspend fun insertSession(session: FocusSessionEntity)

    @Query("SELECT SUM(duration) FROM focus_sessions WHERE date >= :startDate")
    suspend fun getTotalFocusSince(startDate: Long): Int

    @Query("SELECT date, SUM(duration) as total FROM focus_sessions GROUP BY date ORDER BY date DESC LIMIT 7")
    fun getWeeklyFocus(): Flow<DailyFocus>

    data class DailyFocus(val date: Long, val total: Int)
}