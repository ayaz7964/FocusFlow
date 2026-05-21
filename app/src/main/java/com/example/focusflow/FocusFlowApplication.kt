package com.example.focusflow


import android.app.Application
import android.app.NotificationChannel
import android.app.NotificationManager
import android.os.Build
import com.focusflow.data.database.AppDatabase

class FocusFlowApplication : Application() {
    lateinit var database: AppDatabase

    override fun onCreate() {
        super.onCreate()
        database = AppDatabase.getInstance(this)
        createNotificationChannels()
    }

    private fun createNotificationChannels() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            val taskChannel = NotificationChannel(
                "task_reminder",
                "Task Reminders",
                NotificationManager.IMPORTANCE_HIGH
            )
            val habitChannel = NotificationChannel(
                "habit_reminder",
                "Habit Reminders",
                NotificationManager.IMPORTANCE_DEFAULT
            )
            val manager = getSystemService(NotificationManager::class.java)
            manager.createNotificationChannel(taskChannel)
            manager.createNotificationChannel(habitChannel)
        }
    }
}