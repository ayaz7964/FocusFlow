package com.example.focusflow.data.preferences

//class PrefManager {
//}

//package com.focusflow.data.preferences

import android.content.Context
import android.content.SharedPreferences

class PrefManager(context: Context) {
    private val prefs: SharedPreferences = context.getSharedPreferences("focusflow_prefs", Context.MODE_PRIVATE)

    fun isOnboardingCompleted(): Boolean = prefs.getBoolean("onboarding_completed", false)
    fun setOnboardingCompleted() {
        prefs.edit().putBoolean("onboarding_completed", true).apply()
    }
}