package com.example.focusflow.ui.activities

//class MainActivity {
//}

//package com.focusflow.ui.activities

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.focusflow.ui.navigation.NavGraph
import com.focusflow.ui.theme.FocusFlowTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            FocusFlowTheme {
                NavGraph()
            }
        }
    }
}