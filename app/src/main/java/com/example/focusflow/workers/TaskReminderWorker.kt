package com.example.focusflow.workers

//class TaskReminderWorker {
//}

//package com.focusflow.workers

import android.content.Context
import androidx.work.Worker
import androidx.work.WorkerParameters
import com.focusflow.notifications.NotificationHelper

class TaskReminderWorker(context: Context, params: WorkerParameters) : Worker(context, params) {
    override fun doWork(): Result {
        val taskTitle = inputData.getString("task_title") ?: return Result.failure()
        NotificationHelper(applicationContext).showTaskReminder(
            "Task Reminder",
            "Don't forget to complete: $taskTitle"
        )
        return Result.success()
    }
}