package com.example.focusflow.workers

//class DailyResetWorker {
//}

//package com.focusflow.workers

import android.content.Context
import androidx.work.CoroutineWorker
import androidx.work.WorkerParameters
import com.focusflow.data.database.AppDatabase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class DailyResetWorker(context: Context, params: WorkerParameters) : CoroutineWorker(context, params) {
    override suspend fun doWork(): Result = withContext(Dispatchers.IO) {
        try {
            val db = AppDatabase.getInstance(applicationContext)
            val habits = db.habitDao().getAllHabits()
            habits.collect { habitList ->
                habitList.forEach { habit ->
                    if (habit.completedToday) {
                        db.habitDao().updateHabit(habit.copy(completedToday = false))
                    }
                }
            }
            Result.success()
        } catch (e: Exception) {
            Result.retry()
        }
    }
}