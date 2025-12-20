package com.buy2enjoy.returnscanner.ui

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.buy2enjoy.feature_scan.ScanScreen
import com.buy2enjoy.feature_list.ListScreen
import com.buy2enjoy.feature_detail.DetailScreen
import com.buy2enjoy.feature_export.ExportScreen
import com.buy2enjoy.returnscanner.ui.dashboard.DashboardScreen

object Routes {
    const val DASHBOARD = "dashboard"
    const val SCAN = "scan"
    const val LIST = "list"
    const val DETAIL = "detail/{id}"
    const val EXPORT = "export"
}

@Composable
fun AppNavHost(navController: NavHostController) {
    NavHost(navController, startDestination = Routes.DASHBOARD) {
        composable(Routes.DASHBOARD) { DashboardScreen(onNavigate = { navController.navigate(it) }) }
        composable(Routes.SCAN) { ScanScreen(onBack = { navController.popBackStack() }) }
        composable(Routes.LIST) { ListScreen(onBack = { navController.popBackStack() }, onOpenDetail = { id -> navController.navigate("detail/$id") }) }
        composable(
            route = Routes.DETAIL,
            arguments = listOf(androidx.navigation.navArgument("id") { type = androidx.navigation.NavType.LongType })
        ) { backStackEntry ->
            val id = backStackEntry.arguments?.getLong("id") ?: 0L
            DetailScreen(itemId = id, onBack = { navController.popBackStack() })
        }
        composable(Routes.EXPORT) { ExportScreen(onBack = { navController.popBackStack() }) }
    }
}
