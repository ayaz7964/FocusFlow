package com.example.focusflow.data.repository

//class FocusRepository {
//}

//package com.focusflow.data.repository

import com.focusflow.data.database.dao.FocusSessionDao
import com.focusflow.data.database.entities.FocusSessionEntity
import kotlinx.coroutines.flow.Flow

class FocusRepository(private val sessionDao: FocusSessionDao) {

    fun getAllSessions(): Flow<List<FocusSessionEntity>> = sessionDao.getAllSessions()
    suspend fun insertSession(session: FocusSessionEntity) = sessionDao.insertSession(session)
    suspend fun getTotalFocusSince(startDate: Long): Int = sessionDao.getTotalFocusSince(startDate)
    fun getWeeklyFocus(): Flow<FocusSessionDao.DailyFocus> = sessionDao.getWeeklyFocus()
}