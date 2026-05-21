package com.example.focusflow.notifications

//class ReminderScheduler {
//}

//package com.focusflow.notifications

import android.content.Context
import androidx.work.*
import com.example.focusflow.workers.TaskReminderWorker
import java.util.concurrent.TimeUnit

class ReminderScheduler(private val context: Context) {

    fun scheduleTaskReminder(taskTitle: String, deadlineTimestamp: Long) {
        val delay = deadlineTimestamp - System.currentTimeMillis()
        if (delay > 0) {
            val workRequest = OneTimeWorkRequestBuilder<TaskReminderWorker>()
                .setInitialDelay(delay, TimeUnit.MILLISECONDS)
                .setInputData(workDataOf("task_title" to taskTitle))
                .build()
            WorkManager.getInstance(context).enqueue(workRequest)
        }
    }
}