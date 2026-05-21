package com.example.focusflow.ui.navigation

//class NavGraph {
//}
//package com.focusflow.ui.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.focusflow.ui.screens.*

sealed class Screen(val route: String) {
    object Splash : Screen("splash")
    object Onboarding : Screen("onboarding")
    object Home : Screen("home")
    object Tasks : Screen("tasks")
    object AddTask : Screen("add_task")
    object TaskDetail : Screen("task_detail/{taskId}") {
        fun passId(id: Int) = "task_detail/$id"
    }
    object Habits : Screen("habits")
    object AddHabit : Screen("add_habit")
    object Timer : Screen("timer")
    object Analytics : Screen("analytics")
    object Profile : Screen("profile")
}

@Composable
fun NavGraph() {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = Screen.Splash.route) {
        composable(Screen.Splash.route) {
            SplashScreen(navController)
        }
        composable(Screen.Onboarding.route) {
            OnboardingScreen(navController)
        }
        composable(Screen.Home.route) {
            HomeScreen(navController)
        }
        composable(Screen.Tasks.route) {
            TasksScreen(navController)
        }
        composable(Screen.AddTask.route) {
            AddTaskScreen(navController)
        }
        composable(
            route = Screen.TaskDetail.route,
            arguments = listOf(navArgument("taskId") { type = NavType.IntType })
        ) { backStackEntry ->
            val taskId = backStackEntry.arguments?.getInt("taskId") ?: 0
            TaskDetailScreen(navController, taskId)
        }
        composable(Screen.Habits.route) {
            HabitsScreen(navController)
        }
        composable(Screen.AddHabit.route) {
            AddHabitScreen(navController)
        }
        composable(Screen.Timer.route) {
            TimerScreen(navController)
        }
        composable(Screen.Analytics.route) {
            AnalyticsScreen(navController)
        }
        composable(Screen.Profile.route) {
            ProfileScreen(navController)
        }
    }
}